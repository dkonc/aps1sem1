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

		for(int i = 0; i < stUkazov; i++){
            String vhod = sc.next();
            String[] ukazi = vhod.split(",");
            if(ukazi[0].equals("o")){
                list.ohrani(ukazi[1].charAt(0),Integer.parseInt(ukazi[2]));
            }
            else if(ukazi[0].equals("p")){
                list.preslikaj(ukazi[1].charAt(0),Integer.parseInt(ukazi[2]));
            }
            else if(ukazi[0].equals("z")){

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

    public void preslikaj(char op, int val){

    }

    public void ohrani(char op, int val){
        if(Character.toString(op).equals(">")){
            
        }
        if(Character.toString(op).equals("<")){
            
        }
        if(Character.toString(op).equals("=")){
            
        }
    }
    public void zdruzi(char op){

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
		while (el != null)
		{	
			System.out.println(el.idx);
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