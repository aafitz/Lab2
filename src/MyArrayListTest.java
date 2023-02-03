public class MyArrayListTest {
    public static void main(String [] args){
        MyArrayList data = new MyArrayList();


        //adds in elements----
        data.add("hi");
        data.add("hola");
        data.add("CS");

        //test to singly print using get
        //System.out.println(data.get(0));
        //System.out.println(data.get(2));
        // tests add where index is specified and items have to move around
       data.add(2,"bye");
       //data.add(15,"slu"); // tests the throw-- indexout of bounds for the add
        //test to add at the start of the list
      data.add(0,"dog");
      data.get(15); //tests get---element at index 15-- throw--- outofbounds--- for get
       data.add(data.size()-1, "cat"); // tests to add elemnt to the end of the list


       for(int i = 0; i < data.size();i++){ // printing out any elements in the data list -- checks for all basically
           System.out.println(data.get(i));
       }

    }

}
