package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Siparişiniz verildi");

        //Burada config dosyamızı göstermiş olduk
         //Configürasyon dosyamın nerede oldugunu göstermek için Spring framework böyle bir class oluşturmuş
        AnnotationConfigApplicationContext context =
                        new AnnotationConfigApplicationContext(AppConfiguration.class);

        //bean talep ediyoruz,

      // MessageService service =  context.getBean(MessageService.class); // ioc budur newlemeden kullanmak istediğim classlarımı
        //              @component ile işaretliyorum. Kullanmak istediğim Spring Framework gidiyorum oda bana setliyor ve gönderiyor
        //Sprig kullanmak istediğim zaman bana service objesi gönderiyor
        //service instance variable dir.

//        MessageService service = context.getBean("mailService",MessageService.class);
//        MessageService service2 =context.getBean("mailService",MessageService.class);
        MessageService service3 =context.getBean("smsService",MessageService.class);

        /*
         // interface yapısı olunca hangi child i bean olarak oluşturacağını anlayamadıgı için exception fırlatır
            Eğer MessageService interface'nden servis çağırırken servis classlarına @Component(servis adı  ne ise)
        yazılmazsa hangi childi çağıracağını bilemediği için exception atar
        Bunun için classların başına @Component("smsService") gibi yazılır ve üst satırda olduğu gibi çağrılır
         */

//
//        if (service==service2){
//            System.out.println("Aynı");
//        }else{
//            System.out.println("farklı");
//        }

       // service.sendMessage(message);
        service3.sendMessage(message);

        context.close();// programı kapatırken oluşan bean leri yok ediyoruz.





    }
}
/*
AppConfiguration clasımı oluşturarak eklediğim anostasyonlar ile tarama yapılmasını sağlıyorum
Bu tarama neticesinde bean ler tespit ediliyor ve
Ben hangisini kullanacaksam context.getBean() ile çağırıyorum ve kullanıyorum



 */