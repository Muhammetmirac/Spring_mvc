package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("mailService")
@Scope("prototype") //  defaullta sıngleton dur. cagırdıgınızda aynı oje gelir gider. Ancak  @Scope("prototype")
                    // anostasyonu yazılırsa her seferinde yeni bir obje üreterek getirir
public class MailService implements MessageService {
    @Value("${app.email}")  // bu classın içerisinde maili nereden çağırırsak çağıralım app.properties dosyasındaki değişkenden alır gelir
                            //email="email@email.com olarak getirir.  biz field lerin üzerine key leri yazarız
    private String mail;


//    -------------------- FİELD INJECTION  --------------------
//    @Autowired      //  altındaki variable bakar ve işaretler. sanki newleyerek oluşturulmuş concrit class gibi
                                                    //bulunduğu classın herhangi bir yerinde kullanılabilir.----->Dependecy Injection bu oluyor
//    @Qualifier("dbRepository")---->Seçici --> hangi Repository nin çalışmasını istiyorsak belirtiyoruz
    //@Autowired ve @Qualifier abi kardeş gibidir. Beraber kullanılırlar. Bir clas içerisinde başka bir classa ait concrete variable oluşturulacaksa Qqualifier ile işaretlemiş oluyoruz
    // Benim kullandığım bağımlılık; class içerisinde başka bir classı bağımlılık olarak yazıyorsak kullanılır
//   private Repository repository;

    //  -------------------- SETTER INJECTION  --------------------
   // private Repository repository;
/*
hemen set oluşturup üzerine @autowired ve @qualifier ekledik bu şekilde setter injection yapmı şolduk
 */
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }


    //  -------------------- CONSTRUCTOR INJECTION  --------------------
    /*
   TRİCK BİLGİ = eĞER class içerisinde bir tane const. varsa @Autowired yazmaya gerek yoktur

     */

    private Repository repository;

    @Autowired // constructor injection da yazsak da olur yazmasak da olur
    public MailService(@Qualifier("fileRepository") Repository repository) {
        this.repository = repository;
    }

    public void sendMessage(Message message) {
        System.out.println("Ben Mail Servisiyim...\nSize mesaj gönderiyorum\n"
                + message.getMessage());
        repository.saveMessage(message);

    }

}
/*
GÜVENLİK AÇISINDAN EN FAZLA KULLANILAN CONSTRUCTOR INJECTION DUR.
 */