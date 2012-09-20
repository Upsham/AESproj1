package app1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "model")
@XmlType(propOrder = { "price", "frame" , "fork", "components", "rating" })
public class Model {
  private Frame frame;
  private Fork fork;
  private Components components;
  private Rating rating;
  private String price;
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
  public Frame getFrame(){
	  return frame;
  }
  public void setFrame(Frame frame){
	  this.frame = frame;
  }
  public void makeFrame(){
	  frame = new Frame();
  }
  public Fork getFork(){
	  return fork;
  }
  public void setFork(Fork fork){
	  this.fork = fork;
  }
  public void makeFork(){
	  fork = new Fork();
  }
  public Components getComponents(){
	  return components;
  }
  public void setComponents(Components components){
	  this.components = components;
  }
  public void makeComponents(){
	  components = new Components();
  }
  public Rating getRating(){
	  return rating;
  }
  public void setRating(Rating rating){
	  this.rating = rating;
  }
  public void makeRating(){
	  rating = new Rating();
  }
} 
