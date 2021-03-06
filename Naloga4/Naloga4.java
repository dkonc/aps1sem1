import java.util.Scanner;

public class Naloga4{
    public static String[] stevilke;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int steviloUkazov = sc.nextInt();



        LinkedList[] vrece = new LinkedList[5000];
        int steviloVrec = 0;
        for(int i = 0; i < steviloUkazov; i++){
            String vhod = sc.next();
            String[] ukazi = vhod.split(",");
            if(ukazi[0].equals("U")){
                int imeTabele = Integer.parseInt(ukazi[1]);
                int dolzinaVrece = ukazi.length;
                vrece[imeTabele] = new LinkedList();
                //System.out.println(ukazi[2]);
                for(int j = 2; j < dolzinaVrece; j++){
                    String[] notranjiUkaz = ukazi[j].split(":");
                    int element = Integer.parseInt(notranjiUkaz[0]);
                    int steviloElementov = Integer.parseInt(notranjiUkaz[1]);
                    for(int t = 0; t<steviloElementov; t++){
                        vrece[imeTabele].addLast(element);
                    }
                }
                vrece[imeTabele].sort();
                //vrece[imeTabele].write();
            }
            if(ukazi[0].equals("Z")){
                int vreca1 = Integer.parseInt(ukazi[1]);
                int vreca2 = Integer.parseInt(ukazi[2]);
                vrece[vreca1].zdruzi(vreca1,vreca2,vrece);
                vrece[vreca1].write();
                vrece[vreca2].write();

                
            }
        }
    }
}







class LinkedList{


    protected LinkedListElement first;
    protected LinkedListElement last;


    LinkedList()
    {
        makenull();
    }

    //Funkcija makenull inicializira seznam
    public void makenull()
    {
        //drzimo se implementacije iz ucbenika:
        //po dogovoru je na zacetku glava seznama (header)
        first = new LinkedListElement();
        last = null;
    }

    public void sort(){
        LinkedListElement current = first, index = null;  
        int temp;  
          
        if(first == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                index = current.next;  
                  
                while(index != null) {  
                    if(current.idx > index.idx) {  
                        temp = current.idx;  
                        current.idx = index.idx;  
                        index.idx = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  

    }
    public void zdruzi(int vreca1, int vreca2,LinkedList[] vrece){
        LinkedListElement result = null;
        LinkedListElement head = null;
        
        while(vrece[vreca1].first.next != null || vrece[vreca2].first.next != null) {
        int minVal;
        if (vrece[vreca1].first.next == null) {
            minVal = vrece[vreca2].first.next.idx;
            vrece[vreca2].first.next = vrece[vreca2].first.next.next;
        } else if (vrece[vreca2].first.next == null) {
            minVal = vrece[vreca1].first.next.idx;
            vrece[vreca1].first.next = vrece[vreca1].first.next.next;
        } else if(vrece[vreca1].first.idx <= vrece[vreca2].first.next.idx) {
            minVal = vrece[vreca1].first.idx;
            vrece[vreca1].first = vrece[vreca1].first.next;
        } else {
            minVal = vrece[vreca2].first.next.idx;
            vrece[vreca2].first.next = vrece[vreca2].first.next.next;
        }

        if(result == null) {
            result = head = new LinkedListElement(minVal);
        } else {
            result.next = new LinkedListElement(minVal);
            result = result.next;
        }
        }
        vrece[vreca1].first = head;
    }
    public void preslikaj(char op, int val){
        if(Character.toString(op).equals("+")){
            LinkedListElement el = first.next;
            while(el!=null){
                el.idx = el.idx + val;
                el = el.next;
            }
        }

        if(Character.toString(op).equals("*")){
            LinkedListElement el = first.next;
            while(el!=null){
                el.idx = el.idx * val;
                el = el.next;
            }
        }
    }

    void deleteNode(int kljuc){
        LinkedListElement temp = first.next;
        LinkedListElement prev = null;

        if(temp!=null && temp.idx == kljuc){
            first = first.next;
            return;
        }
        while(temp != null && temp.idx != kljuc){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) return;

        prev.next = temp.next;
    }
    public void ohrani(char op, int val){
        if(Character.toString(op).equals(">")){
            LinkedListElement el = first.next;
            while(el!=null){
                if(el.idx <= val){
                    deleteNode(el.idx);
                }
                el = el.next;
            }
        }
        if(Character.toString(op).equals("<")){
            LinkedListElement el = first.next;
            while(el!=null){
                if(el.idx >= val){
                    deleteNode(el.idx);
                }
                el = el.next;
            }
        }
        if(Character.toString(op).equals("=")){
            LinkedListElement el = first.next;
            while(el!=null){
                if(el.idx > val || el.idx < val){
                    deleteNode(el.idx);
                }
                el = el.next;
            }
        }
    }
    public void zdruzi(char op){
        if(Character.toString(op).equals("+")){
            int rezultat = 0;
            LinkedListElement el = first.next;
            while(el!=null){
                rezultat = rezultat + el.idx;
                el = el.next;
            }
            System.out.print(rezultat);
        }
        if(Character.toString(op).equals("*")){
            int rezultat = 1;
            LinkedListElement el = first.next;
            while(el!=null){
                rezultat = rezultat * el.idx;
                el = el.next;
            }
            System.out.print(rezultat);
        }
    }

    public void addLast(int obj)
    {
        //najprej naredimo nov element
        LinkedListElement newEl = new LinkedListElement(obj);

        //ali je seznam prazen?
        // po dogovoru velja: ce je seznam prazen, potem kazalec "last" ne kaze nikamor
        if (last == null)
        {
            //ce seznam vsebuje samo en element, kazalca "first" in "last" kazeta na glavo seznama
            first.next = newEl;
            last = first;
        }
        else
        {
            last.next.next = newEl;
            last = last.next;
        }
    }

    public void write()
    {
        LinkedListElement el;

        //zacnemo pri elementu za glavo seznama
        el = first.next;
        //System.out.println();
        while (el != null)
        {
            if(el.next!=null){
                System.out.print(el.idx + "->");
            }
            else{
                System.out.print(el.idx);
            }
            el = el.next;
        }

        //System.out.println();

    }



}
class LinkedListElement {
    int idx;
    LinkedListElement next;

    LinkedListElement(int el){
        idx = el;
        next = null;
    }

    LinkedListElement(){
        idx = 0;
        next = null;
    }
}