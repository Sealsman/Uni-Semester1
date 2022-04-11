import java.util.EmptyStackException;

public class RPNStack {
    //Reference zum Listenbeginn
    Element firstElement = null;

    public class Element {
        private final int value;
        //Reference zum volgenenden Objekt
        private Element next;

        //zuweisung des Werts
        public Element(int value) {
            this.value = value;
            this.next = null;
        }

        public void setNextElement(Element next) {
            this.next = next;
        }

        public Element getNextElement() {
            return this.next;
        }

        public int getValue() {
            return this.value;
        }
    }

    public void push(int value) {
        //Überprüfen ob elemente vorhanden
        if (firstElement == null) {
            firstElement = new Element(value);
        } else {
            //suchen des letzen elements und erganzen des neuen elements
            Element temp = firstElement;
            while (temp.getNextElement() != null) {
                temp = temp.getNextElement();
            }
            temp.setNextElement(new Element(value));
        }
    }

    public int pop() {
        int re = 0;
        //Überprüfen ob elemente vorhanden
        if (firstElement == null) {
            throw new EmptyStackException();
        } else {
            //Überprüfen ob es ein 2tes element gibt
            if (firstElement.getNextElement() != null) {
                //suchen des letzten Elements
                Element temp = firstElement;
                Element lastElement = temp;
                while (temp.getNextElement() != null) {
                    lastElement = temp;
                    temp = temp.getNextElement();
                }
                re = temp.getValue();
                //löschen des Elements sowie der letzen referenzierung des Elements
                lastElement.setNextElement(null);
                temp = null;
            } else {
                re = firstElement.getValue();
                firstElement = null;
            }
        }
        return re;
    }

    public void add() {
        //addieren der obersten zewei werte und Rückgabe
        //da ich nirgends die exception abfange verzichte ich darauf die werte zwischen zu speicehern im fall das weniger als 2 Werte vorhanden
        push(pop() + pop());
    }

    public void subtract() {
        //subtrahieren der obersten zewei werte und Rückgabe
        //da ich nirgends die exception abfange verzichte ich darauf die werte zwischen zu speicehern im fall das weniger als 2 Werte vorhanden
        push(pop() - pop());
    }

    public void multiply() {
        //multiplizeren der obersten zewei werte und Rückgabe
        //da ich nirgends die exception abfange verzichte ich darauf die werte zwischen zu speicehern im fall das weniger als 2 Werte vorhanden
        push(pop() * pop());
    }

    public static void main(String[] args) {
        RPNStack stack = new RPNStack();

        stack.push(2);
        stack.push(5);
        stack.add();

        stack.push(4);
        stack.push(1);
        stack.subtract();

        stack.multiply();

        int result = stack.pop();
        System.out.println(result);
    }
}
