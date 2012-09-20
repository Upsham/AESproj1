package app1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class test {

  private static final String BRAND_XML = "./brand-jaxb.xml";

  public static void main(String[] args) throws JAXBException, IOException {

    ArrayList<Model> modelList = new ArrayList<Model>();
    ArrayList<String> mat = new ArrayList<String>();
    mat.add("Carbon");
    mat.add("Zinc");
    // create books
    Model model1 = new Model();
    model1.setPrice("$19,000");
    model1.makeFrame();
    model1.getFrame().setYear("1990");
    model1.getFrame().setMaterial(mat);
    modelList.add(model1);
    mat.clear();
    mat.add("Test");
    
    Model model2 = new Model();
    model2.setPrice("$18,000");
    model2.makeFrame();
    model2.makeFork();
    model2.makeComponents();
    model2.makeRating();
    model2.getFrame().makeMaterial();
    model2.getFrame().makeSize();
    model2.getFrame().setYear("1991");
    model2.getFrame().getMaterial().add("Testing");
    model2.getFrame().getSize().add(52);
    model2.getFork().makeMaterial();
    model2.getFork().getMaterial().add("Let's see if this works!");
    model2.getComponents().makeComponent();
    model2.getComponents().getComponent().add("Headrest");
    model2.getComponents().getComponent().add("Bikerest");
    model2.getRating().setMax(5);
    model2.getRating().setCurrent(3.49);
    model2.getRating().setVotes(39);
    modelList.add(model2);

    // create bookstore, assigning book
    Brand brand1 = new Brand();
    brand1.setManufacturer("Bianchi");
    brand1.setModel(modelList);


    // create JAXB context and instantiate marshaller
    JAXBContext context = JAXBContext.newInstance(Brand.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.marshal(brand1, System.out);

    Writer w = null;
    try {
      w = new FileWriter(BRAND_XML);
      m.marshal(brand1, w);
    } finally {
      try {
        w.close();
      } catch (Exception e) {
      }
    }

    // get variables from our xml file, created before
    System.out.println();
    System.out.println("Output from our XML File: ");
    Unmarshaller um = context.createUnmarshaller();
    Brand brand2 = (Brand) um.unmarshal(new FileReader(BRAND_XML));

    for (int i = 0; i < brand2.getModel().toArray().length; i++) {
      System.out.println("Model " + (i + 1) + ": " + brand2.getModel().get(i).getPrice()+" Year:"+brand2.getModel().get(i).getFrame().getYear() + " First Frame Material:"+brand2.getModel().get(i).getFrame().getMaterial().toString());
          //+ bookstore2.getBooksList().get(i).getName() + " from "
          //+ bookstore2.getBooksList().get(i).getAuthor());
    }

  }
} 