package chapter3.variantb.triangle.action;

import chapter3.variantb.triangle.entity.Triangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sukhocheva Maryana
 */
public class InputData {
    public static  List<Triangle> generationTriangles(){
      List<Triangle> arrayOfTriangles = new ArrayList<>();
      try {
        arrayOfTriangles.add(new Triangle(5.));
        arrayOfTriangles.add(new Triangle(5., 4., 3.));
        arrayOfTriangles.add(new Triangle(1., 1.5, 1.));
        arrayOfTriangles.add(new Triangle(10.6, 8., 4.));
        arrayOfTriangles.add(new Triangle(10.));
        
         } catch (Exception ex) {
            System.err.println("Error when creating triangles");
        }
        System.out.println("Создан массив треугольников");
        return arrayOfTriangles;

    }
}
