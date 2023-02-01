package polygons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSubtyping {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Graphics g = frame.getGraphics();
        testSubtyping(g);
    }

    public static void testSubtyping(Graphics g) {
        // TODO: Step 0a: Look at these six variables, and their
        //  static (declared) types. We're going to test them
        //  in various ways, so remember what the static types are.
        Polygon[]      polyArray = new Polygon[10];
        Triangle[]     triArray  = new Triangle[10];

        List<Polygon>  polyList  = new ArrayList<>();
        List<Triangle> triList   = new ArrayList<>();

        List<? extends Polygon> coPolyList     = new ArrayList<>();
        List<? super Polygon>   contraPolyList = new ArrayList<>();

        // TODO: Step 0b: Look at these four variables, and their
        //  static (declared) types AND dynamic types. We're going
        //  to use them to test the collections above.
        Object   obj = new Object();
        Polygon  pol = new Triangle(1, 1);
        Triangle tri = new Triangle(2, 2);
        Square   squ = new Square(3, 3);


        // TODO: Step 1a: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
//        polyArray[0] = pol;                   // OK/Static error/Dynamic error
//        polyArray[1] = tri;                   // ____
//        triArray[0]  = pol;                   // ____
//        triArray[1]  = tri;                   // ____
//        triArray[2]  = (Triangle) pol;        // ____
//
//        polyList.add(pol);                    // ____
//        polyList.add(tri);                    // ____
//        triList.add(pol);                     // ____
//        triList.add(tri);                     // ____
//        triList.add((Triangle) pol);          // ____
//        triList.add((Triangle) obj);          // ____
//
//        coPolyList.add(pol);                  // ____
//        coPolyList.add(tri);                  // ____
//        coPolyList.add(obj);
//        contraPolyList.add(pol);              // ____
//        contraPolyList.add(tri);              // ____
//        contraPolyList.add(obj);              // ____

        // TODO: Step 1b: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        obj = polyList.get(0);              // OK/Static error/Dynamic error
//        pol = polyList.get(0);              // ____
//        tri = polyList.get(0);              // ____
//        tri = (Triangle) polyList.get(0);   // ____
//        pol = triList.get(0);               // ____
//        tri = triList.get(0);               // ____
//
//        pol = coPolyList.get(0);            // ____
//        tri = coPolyList.get(0);            // ____
//        pol = contraPolyList.get(0);        // ____
//        tri = contraPolyList.get(0);        // ____
//        obj = contraPolyList.get(0);        // ____


        // TODO: Step 1c: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        triArray  = (Triangle[]) polyArray;         // OK/Static error/Dynamic error
//        polyArray = triArray;                       // ____
//        triArray  = polyArray;                      // ____
//        triArray  = (Triangle[]) polyArray;         // ____
//
//        triList  = polyList;                        // ____
//        polyList = triList;                         // ____
//        polyList = (List<Triangle>) triList;        // ____
//
//        coPolyList = polyList;                      // ____
//        coPolyList = triList;                       // ____
//        polyList   = coPolyList;                    // ____
//        triList    = coPolyList;                    // ____
//
//        contraPolyList = polyList;                  // ____
//        contraPolyList = triList;                   // ____
//        polyList       = contraPolyList;            // ____
//        triList        = contraPolyList;            // ____
//
//        coPolyList     = contraPolyList;            // ____
//        contraPolyList = coPolyList;                // ____
//
//        for (Polygon p : coPolyList)
//            contraPolyList.add(p);                  // ____


        // TODO: Step 2a: Predict what the results of these lines will be.
        //    Will they work, or will they lead to a static type error?
        //    Then, uncomment them add check. Were your answers correct?
//        paintAll(g, polyList);          // Ok/Error
//        paintAll(g, triList);           // ____
        // TODO: Step 2b: There's no reason why 'paintAll' shouldn't
        //    work for both lists. Can you change the parameter type
        //    for 'polygons' in the declaration of 'paintAll' below,
        //    so that it works for both cases above?


        // TODO: Step 3a: Predict what the results of these lines will be.
        //    Will they work, or will they lead to a static type error?
        //    Then, uncomment them add check. Were your answers correct?
//        addAll(polyList, polyList);       // Ok/Error
//        addAll(triList, polyList);        // ____
//        addAll(polyList, triList);        // ____
//        addAll(triList, triList);         // ____
        // TODO: Step 3b: Can you change the parameter types for 'from'
        //    and 'to' in the declaration of 'addAll' below, to make it
        //    work for three out of four cases above?
        //    Why can you not make it work for the fourth?
        //    (Hint: it's for a good reason.)


        final Polygon polygon = pol;
        // TODO: Step 4: Look up the types of the three following methods
        //    from Java's standard libraries (hover over the method names
        //    in IntelliJ, don't mind the warnings).
        //    Can you explain why they have the declared types they do?
        polyList.addAll(triList);                       // What is the parameter type of addAll? ____
        boolean b = polyList.containsAll(triList);      // What is the parameter type of containsAll? ____
        polyList.removeIf(p -> p.equals(polygon));      // What is the parameter type of removeIf? ____


        // TODO: Step 5: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        polyArray = triArray;           // OK/Static error/Dynamic error
//        polyArray[0] = squ;             // ____
//        tri = triArray[0];              // ____
//
//        polyList = triList;             // ____
//        polyList.add(0, squ);           // ____
//        tri = triList.get(0);           // ____

    }

    // TODO: Step 2b: Change the parameter type of 'polygons' to
    //    the broadest (most general) type possible with respect
    //    to how it is used in the method body.
    public static void paintAll(Graphics g, List<Polygon> polygons) {
        for (Polygon p : polygons)
            p.paint(g);
    }

    // TODO: Step 2d: Change the parameter types of 'from' and 'to' to
    //    the broadest (most general) types possible, given how they
    //    are used respectively in the method body.
    public static void addAll(List<Polygon> from, List<Polygon> to) {
        for (Polygon p : from)
            to.add(p);
    }

}
