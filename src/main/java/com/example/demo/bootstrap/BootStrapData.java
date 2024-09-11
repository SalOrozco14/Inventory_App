package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    //Task E- Added inhouse repo as class variable
    private final InhousePartRepository inhousePartRepository;

    //Task E - added Inhouse Repo to BootStrapData constructor
    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,
                         OutsourcedPartRepository outsourcedPartRepository,
                         InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;

        //Task E - Added Inhouse repo local variable
        this.inhousePartRepository = inhousePartRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        //Task E create Inhouse parts(Ingredients), Outsourced parts(Ingredients), Products(Sushi)
        //Checks if Database is empty. If it is, will load sample data to the app

        if((outsourcedPartRepository.count() +inhousePartRepository.count() + productRepository.count())== 0){

            //Create sample outsourced ingredients for database
            //----------------------------------------------

            //Create Sweet Water Shrimp
            OutsourcedPart shrimp = new OutsourcedPart();
            shrimp.setCompanyName("S.W. Shrimp CO.");
            shrimp.setName("Sweet Water Shrimp");
            shrimp.setInv(100);
            shrimp.setPrice(5.00);
            shrimp.setId(100L);
            //TASK G: adding min.max
            shrimp.setMinInv(10);
            shrimp.setMaxInv(150);
            outsourcedPartRepository.save(shrimp);

            //Create Crab Stix
            OutsourcedPart crab = new OutsourcedPart();
            crab.setCompanyName("Yummy Crab LLC");
            crab.setName("Crab Stix");
            crab.setInv(150);
            crab.setPrice(2.00);
            crab.setId(101L);
            //TASK G: adding min.max
            crab.setMinInv(10);
            crab.setMaxInv(150);
            outsourcedPartRepository.save(crab);

            //Create Nori Paper to repo
            OutsourcedPart nori = new OutsourcedPart();
            nori.setCompanyName("SeaPaper LLC");
            nori.setName("Nori Paper");
            nori.setInv(80);
            nori.setPrice(1.00);
            nori.setId(102L);
            //TASK G: adding min.max
            nori.setMinInv(10);
            nori.setMaxInv(150);
            outsourcedPartRepository.save(nori);

            //Create sample inhouse ingredients for database
            //----------------------------------------------

            //Create Rice
            InhousePart rice = new InhousePart();
            rice.setName("Rice");
            rice.setInv(100);
            rice.setPrice(.50);
            rice.setPartId(1);
            rice.setId(103L);
            //TASK G: adding min.max
            rice.setMinInv(10);
            rice.setMaxInv(150);
            inhousePartRepository.save(rice);

            //Create Cucumber
            InhousePart cucumber = new InhousePart();
            cucumber.setName("Cucumber");
            cucumber.setInv(102);
            cucumber.setPrice(.25);
            cucumber.setPartId(2);
            cucumber.setId(104L);
            //TASK G: adding min.max
            cucumber.setMinInv(10);
            cucumber.setMaxInv(150);
            inhousePartRepository.save(cucumber);

            //Create sample products for the database
            //---------------------------------------

            //Create Shrimp Roll
            Product shrimpRoll = new Product("Shrimp Roll",18.0,15);
            //Save product to database
            productRepository.save(shrimpRoll);

            //Create crab Roll
            Product crabRoll = new Product("Crab Roll", 18.0,15);
            //Save product to database
           productRepository.save(crabRoll);

           //Create Veggi roll
            Product veggi = new Product("Veggi Roll", 12.0, 15);
           //save product to database
           productRepository.save(veggi);

           //create crab nigiri
            Product crabNigiri = new Product("Crab Nigiri", 8.0, 20);
            //save product to database
            productRepository.save(crabNigiri);

            // create shrimp Nigiri
            Product shrimpNigiri = new Product("Shrimp Nigiri", 8.0, 20);
            //save product to database
            productRepository.save(shrimpNigiri);

       }

        //Task E- prints outsourced part data.
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        //Task E- List and for loop to print out Inhouse data sample
        List<InhousePart> inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:inhouseParts){
            System.out.println(part.getName()+" "+part.getPartId());
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
