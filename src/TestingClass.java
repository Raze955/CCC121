import data_structures.list.List;

public class TestingClass {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List list = new List(array);

        list.traverse();
    }
}
