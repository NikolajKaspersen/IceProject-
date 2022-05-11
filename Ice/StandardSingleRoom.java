package Ice;
import java.io.Serializable;
import java.util.ArrayList;
public class StandardSingleRoom implements Serializable{
        String name;
        String contact;
        String gender;
        ArrayList<Food> food =new ArrayList<>();

        StandardSingleRoom()
        {
            this.name="";
        }
        StandardSingleRoom(String name, String contact, String gender)
        {
            this.name=name;
            this.contact=contact;
            this.gender=gender;
        }

}
