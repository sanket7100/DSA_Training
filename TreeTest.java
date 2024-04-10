import java.util.Scanner;

public class TreeTest {

    public static void main(String args[]) {

        MyTree tree = new MyTree();

        int ch;
        System.out.println("\nOPERATIONS ---");
        System.out.println("\n1 - Insert an element into tree\n");
        System.out.println("2 - Delete an element from the tree\n");
        System.out.println("3 - Inorder Traversal\n");
        System.out.println("4 - Preorder Traversal\n");
        System.out.println("5 - Postorder Traversal\n");
        System.out.println("6 - Exit\n");

        while (true) {
            System.out.println("\nEnter your choice : ");
            Scanner scan = new Scanner(System.in);
            ch = scan.nextInt();

            switch (ch) {
                case 1:
                    tree.insert();
                    break;
                case 2:
                    tree.delete();
                    break;
                case 3:
                    tree.inorder(tree.root);
                    break;
                case 4:
                    tree.preorder(tree.root);
                    break;
                case 5:
                    tree.postorder(tree.root);
                    break;
                case 6:
                    System.exit(0);

                default:
                    System.out.println("Wrong choice, Please enter correct choice  ");
                    break;
            }
            scan.close();
        }

    }
}

class btnode {
    int value;
    btnode l;
    btnode r;
}

class MyTree {

    btnode root = null, temp = null, t2, t1;
    int flag = 1;

    /* To insert a node in the tree */
    void insert() {
        create();
        if (root == null)
            root = temp;
        else
            search(root);
    }

    /* To create a node */

    void create() {
        int data;
        System.out.println("Enter data of node to be inserted : ");

        Scanner scan = new Scanner(System.in);
        data = scan.nextInt();

        // temp = ( btnode *)malloc(1*sizeof( btnode));
        temp = new btnode();
        temp.value = data;
        temp.l = temp.r = null;
        scan.close();
    }

    /* Function to search the appropriate position to insert the new node */
    void search(btnode t) {

        if ((temp.value > t.value) && (t.r != null)) /* value more than root node value insert at right */

            search(t.r);

        else if ((temp.value > t.value) && (t.r == null))

            t.r = temp;

        else if ((temp.value < t.value) && (t.l != null)) /* value less than root node value insert at left */

            search(t.l);

        else if ((temp.value < t.value) && (t.l == null))

            t.l = temp;

    }

    /* recursive function to perform inorder traversal of tree */

    void inorder(btnode t) {
        if (root == null) {
            System.out.println("No elements in a tree to display");
            return;
        }

        if (t.l != null)

            inorder(t.l);

        System.out.println(t.value);

        if (t.r != null)

            inorder(t.r);

    }

    /* To check for the deleted node */

    void delete()

    {

        int data;

        if (root == null)

        {

            System.out.println("No elements in a tree to delete");

            return;

        }

        System.out.println("Enter the data to be deleted : ");

        Scanner scan = new Scanner(System.in);
        data = scan.nextInt();

        t1 = root;

        t2 = root;

        search1(root, data);
        scan.close();
    }

    /* To find the preorder traversal */

    void preorder(btnode t)

    {

        if (root == null)

        {

            System.out.println("No elements in a tree to display");

            return;

        }

        System.out.println(t.value);

        if (t.l != null)

            preorder(t.l);

        if (t.r != null)

            preorder(t.r);

    }

    /* To find the postorder traversal */

    void postorder(btnode t)

    {

        if (root == null)

        {

            System.out.println("No elements in a tree to display ");

            return;

        }

        if (t.l != null)

            postorder(t.l);

        if (t.r != null)

            postorder(t.r);

        System.out.println(t.value);

    }

    /* Search for the appropriate position to insert the new node */

    void search1(btnode t, int data)

    {

        if ((data > t.value))

        {

            t1 = t;

            search1(t.r, data);

        }

        else if ((data < t.value))

        {

            t1 = t;

            search1(t.l, data);

        }

        else if ((data == t.value))

        {

            delete1(t);

        }

    }

    /* To delete a node */

    void delete1(btnode t)

    {

        int k;

        /* To delete leaf node */

        if ((t.l == null) && (t.r == null))

        {

            if (t1.l == t)

            {

                t1.l = null;

            }

            else

            {

                t1.r = null;

            }

            t = null;

            return;

        }

        /* To delete node having one left hand child */

        else if ((t.r == null))

        {

            if (t1 == t)

            {

                root = t.l;

                t1 = root;

            }

            else if (t1.l == t)

            {

                t1.l = t.l;

            }

            else

            {

                t1.r = t.l;

            }

            t = null;

            return;

        }

        /* To delete node having right hand child */

        else if (t.l == null)

        {

            if (t1 == t)

            {

                root = t.r;

                t1 = root;

            }

            else if (t1.r == t)

                t1.r = t.r;

            else

                t1.l = t.r;

            t = null;

            return;

        }

        /* To delete node having two child */

        else if ((t.l != null) && (t.r != null))

        {

            t2 = root;

            if (t.r != null)

            {

                k = smallest(t.r);

                flag = 1;

            }

            else

            {

                k = largest(t.l);

                flag = 2;

            }

            search1(root, k);

            t.value = k;

        }

    }

    /* To find the smallest element in the right sub tree */

    int smallest(btnode t)

    {

        t2 = t;

        if (t.l != null)

        {

            t2 = t;

            return (smallest(t.l));

        }

        else

            return (t.value);

    }

    /* To find the largest element in the left sub tree */

    int largest(btnode t)

    {

        if (t.r != null)

        {

            t2 = t;

            return (largest(t.r));

        }

        else

            return (t.value);

    }
}