import java.util.Scanner;

public class Naloga3{
    public static String[] stevilke;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        String tabela = sc.next();
        stevilke = tabela.split(",");
        int stUkazov = sc.nextInt();
        LinkedList list = new LinkedList();

        for(int i = 0; i < stevilke.length; i++){
            list.addLast(Integer.parseInt(stevilke[i]));
        }
        //list.write();
        //System.out.println();
        //list.deleteNode(13);
        //list.write();

		for(int i = 0; i < stUkazov; i++){
            String vhod = sc.next();
            String[] ukazi = vhod.split(",");
            if(ukazi[0].equals("o")){
                list.ohrani(ukazi[1].charAt(0),Integer.parseInt(ukazi[2]));
                list.write();
            }
            else if(ukazi[0].equals("p")){
                list.preslikaj(ukazi[1].charAt(0),Integer.parseInt(ukazi[2]));
                list.write();
            }
            else if(ukazi[0].equals("z")){
                list.zdruzi(ukazi[1].charAt(0));
            }
            
            System.out.println();

        }
        //list.write();
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
                System.out.print(el.idx + ",");
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