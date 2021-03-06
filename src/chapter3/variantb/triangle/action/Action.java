package chapter3.variantb.triangle.action;
import chapter3.variantb.triangle.entity.Triangle;
import java.util.List;
/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    public Action() {
    }

    //Равносторонний
    public static boolean isEquilateral(Triangle triangle) {
        checkNull(triangle);
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
        return (a == b && a == c);
    }

    //Равнобедренный
    public static boolean isIsosceles(Triangle triangle) {
        checkNull(triangle);
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
        return ((a == b && a != c) || (a == c && a != b) || (b == c && b != a));
    }

    //Прямоугольный (площадь = половина произведения катетов)
    public static boolean isRect(Triangle triangle) {
        checkNull(triangle);
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
        double s = triangle.getArea();
        double halfAB;

        if (a > b && a > c) {
            halfAB = b * c / 2;
        } else if (b > a && b > c) {
            halfAB = a * c / 2;
        } else {
            halfAB = a * b / 2;
        }

        return (s == halfAB);
    }
    
     //Произвольный 
    public static boolean isArbitrary(Triangle triangle) {
        return !isIsosceles(triangle) && !isEquilateral(triangle) && !isRect(triangle);
    }
    
//количество равносторонних треугольников
    public static int equilateralCount(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);

        return equilateralCount(trianglesArray);
    }

    public static int equilateralCount(Triangle... triangles) {
        checkNull(triangles);

        int sum = 0;

        for (Triangle triangle : triangles) {
            if (isEquilateral(triangle)) {
                sum++;
            }
        }

        return sum;
    }
        //количество равнобедренных треугольников
    public static int isoscelesCount(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);

        return isoscelesCount(trianglesArray);
    }

    public static int isoscelesCount(Triangle... triangles) {
        checkNull(triangles);

        int sum = 0;

        for (Triangle triangle : triangles) {
            if (isIsosceles(triangle)) {
                sum++;
            }
        }

        return sum;
    }
    //количество прямоугольных треугольников
    public static int rectCount(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);

        return rectCount(trianglesArray);
    }

    public static int rectCount(Triangle... trianglesArray) {
        int sum = 0;

        for (Triangle triangle : trianglesArray) {
            if (isRect(triangle)) {
                sum++;
            }
        }

        return sum;
    }
     
        //количество произвольных треугольников
    public static int arbitraryCount(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);

        return arbitraryCount(trianglesArray);
    }

    public static int arbitraryCount(Triangle... triangles) {
        checkNull(triangles);

        int sum = 0;

        for (Triangle triangle : triangles) {
            if (isArbitrary(triangle)) {
                sum++;
            }
        }

        return sum;
    }
     // Наибольший по площади объект
    public static Triangle getMaxAreaTriangle(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);

        return getMaxAreaTriangle(trianglesArray);
    }

    public static Triangle getMaxAreaTriangle(Triangle... triangles) {
        checkNull(triangles);

        Triangle maxAreaTriangle = triangles[0];

        for (int i = 1, size = triangles.length; i < size; i++) {
            if (triangles[i].getArea() > maxAreaTriangle.getArea()) {
                maxAreaTriangle = triangles[i];
            }
        }

        return maxAreaTriangle;
    }
    //Наименьший по площади объект
    public static Triangle getMinAreaTriangle(List<Triangle> triangles) {
        checkNull(triangles);

        Triangle[] trianglesArray = new Triangle[triangles.size()];
        trianglesArray = triangles.toArray(trianglesArray);
   
        return getMinAreaTriangle(trianglesArray);
    }

    public static Triangle getMinAreaTriangle(Triangle... triangles) {
        checkNull(triangles);

        Triangle minAreaTriangle = triangles[0];

        for (int i = 1, size = triangles.length; i < size; i++) {
            if (triangles[i].getArea() < minAreaTriangle.getArea()) {
                minAreaTriangle = triangles[i];
            }
        }

        return minAreaTriangle;
    }

    private static void checkNull(Object object){
        if (object == null){
            throw new IllegalArgumentException();
        }
    }

}
