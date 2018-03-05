package com.luigi.petagram.javaMail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail extends AsyncTask<Void,Void,Void>{


    private Context context;
    private Session session;

    private String email;
    private String subject;
    private String message;

    private ProgressDialog progressDialog;

    public EnviarMail(Context context, String email, String subject, String message){
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Enviando mensaje","Espere un momento...",false,false);
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        Toast.makeText(context,"Su mensaje se ha enviado.",Toast.LENGTH_LONG).show();
    }
    @Override
    protected Void doInBackground(Void... params) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfigurarMail.EMAIL, ConfigurarMail.PASSWORD);
                    }
                });
        try {

            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(email));
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(ConfigurarMail.EMAIL));
            mm.setSubject(subject);
            mm.setText(message);
            Transport.send(mm);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
