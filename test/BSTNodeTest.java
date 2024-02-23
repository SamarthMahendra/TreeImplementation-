
import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.junit.Assert.*;
import solutionv2.*;

public class BSTNodeTest {

    @Test
    public void testInsertions() {
        BSTNode<Integer> root = new BSTEmptyNode<Integer>();
        Set<Integer> expected = new TreeSet<Integer>();

        for (int i=0;i<1000;i++) {
            expected.add((int)(Math.random()*2000-1000));
        }

        for (Integer e:expected) {
            root = root.insert(e);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer e:expected) {
            sb.append(e + " ");

        }
        String output = sb.toString();
        output = output.substring(0,output.length()-1);



        assertEquals(output,root.toString());
    }

    @Test
    public void testMinMax() {
        BSTNode<Integer> root = new BSTEmptyNode<Integer>();
        TreeSet<Integer> expected = new TreeSet<Integer>();

        for (int i=0;i<1000;i++) {
            expected.add((int)(Math.random()*2000-1000));
        }

        for (Integer e:expected) {
            root = root.insert(e);
        }



        assertEquals(expected.first(),root.minimum());
        assertEquals(expected.last(),root.maximum());
    }

    @Test (expected= NothingThereException.class)
    public void testMinWhenEmpty() {
        new BSTEmptyNode<Integer>().minimum();
    }

    @Test (expected= NothingThereException.class)
    public void testMaxWhenEmpty() {
        new BSTEmptyNode<Integer>().maximum();
    }

    @Test
    public void testContains() {
        BSTNode<Integer> root = new BSTEmptyNode<>();
        List<Integer> expected = new ArrayList<Integer>();

        for (int i=0;i<1000;i++) {
            expected.add((int)(Math.random()*2000-1000));
        }

        for (Integer e:expected) {
            root = root.insert(e);
        }


        for (int i=-1000;i<=1000;i++) {
            assertEquals(expected.contains(i),root.contains(i));
        }
    }

  /*
                              10
                   5                   15
           1             7                      20
                2     6.      8               19
   */

    @Test
    public void testPreorder() {
        BSTNode<Integer> root = new BSTEmptyNode<>();

        root = root.insert(10);
        root = root.insert(15);
        root = root.insert(5);
        root = root.insert(1);
        root = root.insert(2);
        root = root.insert(7);
        root = root.insert(6);
        root = root.insert(8);
        root = root.insert(20);
        root = root.insert(19);

        List<Integer> expectedList = Arrays.asList(10,5,1,2,7,6,8,15,20,19);

        List<Integer> actualList = new ArrayList<Integer>();

        root.preorder(i->actualList.add(i));

        assertEquals(expectedList,actualList);


    }


    /*
                                10
                     5                   15
             1             7                      20
                  2     6.      8               19
     */
    @Test
    public void testPostorder() {
        BSTNode<Integer> root = new BSTEmptyNode<>();

        root = root.insert(10);
        root = root.insert(15);
        root = root.insert(5);
        root = root.insert(1);
        root = root.insert(2);
        root = root.insert(7);
        root = root.insert(6);
        root = root.insert(8);
        root = root.insert(20);
        root = root.insert(19);

        List<Integer> expectedList = Arrays.asList(2,1,6,8,7,5,19,20,15,10);

        List<Integer> actualList = new ArrayList<Integer>();

        root.postorder(i->actualList.add(i));

        assertEquals(expectedList,actualList);


    }

    /*
                                10
                     5                   15
             1             7                      20
                  2     6.      8               19
     */
    @Test
    public void testCopy() {
        BSTNode<Integer> root = new BSTEmptyNode<>();

        root = root.insert(10);
        root = root.insert(15);
        root = root.insert(5);
        root = root.insert(1);
        root = root.insert(2);
        root = root.insert(7);
        root = root.insert(6);
        root = root.insert(8);
        root = root.insert(20);
        root = root.insert(19);

        List<Integer> expectedList = Arrays.asList(2,1,6,8,7,5,19,20,15,10);

        List<Integer> actualList = new ArrayList<Integer>();

        BSTNode<Integer> copy = root.copy();

        copy.postorder(i->actualList.add(i));

        assertEquals(expectedList,actualList);


    }

    /*
                                10
                     5                   15
             1             7                      20
                  2     6.      8               19
     */
    @Test
    public void testSameness() {
        BSTNode<Integer> root = new BSTEmptyNode<>();
        BSTNode<Integer> anotherRoot = new BSTEmptyNode<Integer>();

        root = root.insert(10);
        root = root.insert(15);
        root = root.insert(5);
        root = root.insert(1);
        root = root.insert(2);
        root = root.insert(7);
        root = root.insert(6);
        root = root.insert(8);
        root = root.insert(20);
        root = root.insert(19);

        anotherRoot = anotherRoot.insert(10);
        anotherRoot = anotherRoot.insert(15);
        anotherRoot = anotherRoot.insert(5);
        anotherRoot = anotherRoot.insert(1);
        anotherRoot = anotherRoot.insert(2);
        anotherRoot = anotherRoot.insert(7);
        anotherRoot = anotherRoot.insert(6);
        anotherRoot = anotherRoot.insert(8);
        anotherRoot = anotherRoot.insert(20);
        anotherRoot = anotherRoot.insert(19);

        List<Integer> expectedList = Arrays.asList(2,1,6,8,7,5,19,20,15,10);

        List<Integer> actualList = new ArrayList<Integer>();

        BSTNode<Integer> copy = root.copy();

        assertTrue(root.same(anotherRoot));
        assertTrue(root.same(copy));


    }






}