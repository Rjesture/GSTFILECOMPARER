package Book.Book;

import java.util.ArrayList;
import java.util.List;

public class ValCompare {
    //private List<Entries> entryC = new ArrayList<>();
    public List<Entries> compare(List<Entries> entryA, List<Entries> entryC) {
        int c=entryA.size();
        int k=0;
        for(int i=0;i<c;){
            k=0;
            for(int j=0;j<c;j++){
                if(entryA.get(i).getGstno().equalsIgnoreCase(entryA.get(j).getGstno())&&entryA.get(i).getDate().compareTo(entryA.get(j).getDate())==0&&entryA.get(i).getSource().equalsIgnoreCase("Book1")&&entryA.get(j).getSource().equalsIgnoreCase("Book2")
                        &&((entryA.get(i).getTotal()-entryA.get(j).getTotal()<5)||(entryA.get(j).getTotal()-entryA.get(i).getTotal()<5))
                        &&((entryA.get(i).getTvalue()-entryA.get(j).getTvalue()<5)||(entryA.get(j).getTvalue()-entryA.get(i).getTvalue()<5))
                        &&((entryA.get(i).getCgst()-entryA.get(j).getCgst()<5)||(entryA.get(j).getCgst()-entryA.get(i).getCgst()<5))
                        &&((entryA.get(i).getIgst()-entryA.get(j).getIgst()<5)||(entryA.get(j).getIgst()-entryA.get(i).getIgst()<5))
                        &&((entryA.get(i).getSgst()-entryA.get(j).getSgst()<5)||(entryA.get(j).getSgst()-entryA.get(i).getSgst()<5))){
                    entryA.remove(i);
                    entryA.remove(j-1);
                    c=entryA.size();
                k++;
                j=c;
                    System.out.println("Deleted");
                }
            }
            if(k!=1)
                i++;
            else
                i=0;
        }
        return entryA;
    }
}