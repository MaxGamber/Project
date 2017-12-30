package beans;
 
public class File{
   private int id;
   private String name;
   private String composer;
   private String type;
   private float price;
 
   public File() {}
 
   public File(int id, String name, String composer, String type, float price) {
       this.id = id;
       this.name = name;
       this.composer = composer;
       this.type = type;
       this.price = price;
   }

   public int getId() {
	   return id;
   }

   public void setId(int id) {
	   this.id = id;
   }

   public String getName() {
	   return name;
   }

   public void setName(String name) {
	   this.name = name;
   }

   public String getComposer() {
	   return composer;
   }

   public void setComposer(String composer) {
	   this.composer = composer;
   }

   public String getType() {
	   return type;
   }

   public void setType(String type) {
	   this.type = type;
   }

   public float getPrice() {
	   return price;
   }

   public void setPrice(float price) {
	   this.price = price;
   }
}
