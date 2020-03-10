import java.lang.Math.*;
import java.util.*;

class Shape
{
	String name;
	Shape(String newName)
	{
		this.name = newName;	//might need to remove the this.
	}
	public double area()
	{
		return 0.0;
	}
	public void draw()
	{
		System.out.println("Shape.draw() You should never see this.");
	}
	public void description()
	{
		System.out.println("This function will be used to print the dimensions of a shape.");
	}
	public void printName()
	{
		System.out.printf("Name of Shape: %s\n", name);
	}
}

class Triangle extends Shape
{
	int height;
	int base;
	Triangle(String newName, int h, int b)
	{
		super(newName);
		this.height = h;
		this.base = b;
	}
	@Override
	public double area()
	{
		return (double) ( (height * base) / 2.0 );
	}
	@Override
	public void draw()
	{
		System.out.print("\n");
		String display = "             *             \n" +
						 "            ***            \n" +
						 "           *****           \n" +
						 "          *******          \n" +
						 "         *********         \n" +
						 "        ***********        \n" +
						 "       *************       \n" +
						 "      ***************      \n" +
						 "     *****************     \n" +
						 "    *******************    \n" +
						 "   *********************   \n";

		System.out.println(display);
	}
	@Override
	public void description()
	{
		System.out.printf("%s: height=%d, base=%d\n", name, height, base);
	}
}

class Circle extends Shape
{
	int radius;
	Circle(String newName, int r)
	{
		super(newName);
		this.radius = r;
	}
	@Override
	public double area()
	{
		return (double) (Math.PI * radius * radius);
		//return (double) (Math.PI * radius * radius);
	}
	@Override
	public void draw()
	{
		System.out.print("\n");
		String display =    
						 "        **************\n" +
						 "      ******************\n" +
						 "    *********************\n" +
						 "   ************************\n" +
					     "  **************************\n" +
					     " ****************************\n" +
					     " ****************************\n" +
					     " ****************************\n" +
					     " ****************************\n" +
					     " ****************************\n" +
						 "  **************************\n" +
						 "   ************************\n" +
						 "    **********************\n" +
						 "      ******************\n" +
						 "        ***************\n";    
		
		System.out.println(display);
	}
	@Override
	public void description()
	{
		System.out.printf("%s: radius=%d\n", name, radius);
	}
}					   



class Square extends Shape
{
	int sideLength;
	Square(String shapeName, int length)
	{
		super(shapeName);
		this.sideLength = length;
	}
	@Override 
	public double area()
	{
		return (double) (sideLength * sideLength);
	}
	@Override
	public void draw()
	{
		System.out.print("\n");
		String display = "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n" +
						 "     ********************\n";
		
		System.out.println(display);
	}
	@Override
	public void description()
	{
		System.out.printf("%s: side=%d\n", name, sideLength);
	}
}


class Rectangle extends Square
{
	int length;
	int width;
	Rectangle(String newName, int l, int w)
	{
		super(newName, l);
		this.length = l;
		this.width = w;
	}
	@Override 
	public double area()
	{
		return (double) (length * width);
	}
	@Override
	public void draw()
	{
		System.out.print("\n");
		String display = "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n" +
						 "      ***********************\n";

		System.out.println(display);
	}
	@Override
	public void description()
	{
		System.out.printf("%s: length=%d, width=%d\n", name, length, width);
	}
}

class Picture
{
	LinkedList<Shape> myList;
	Picture()
	{
		this.myList = new LinkedList<Shape>();
	}
	public void add(Shape sh)
	{
		myList.add(sh);
	}
	public void drawAll()
	{
		for (Shape sh : myList)
		{
			sh.draw();
		}
	}
	public double totalArea()
	{
		double area = 0.0;
		//double n;
		for (Shape sh : myList)
		{
			//n = sh.area();
			area += sh.area();
			//System.out.printf("n is %f\n", n);
		}
		return area;
	}
	public void printShapes()
	{
		Shape sh;
		for (int index = 0; index < myList.size(); index++)
		{
			sh = myList.get(index);
			sh.description();
			sh.draw();
		}
	}		
}

public class mainClass
{
	static void println(double d)
	{
		System.out.println("Double d is " + d);
	}
	public static void main(String[] args)
	{
		Picture p = new Picture();
		p.add(new Triangle("First Triangle", 5, 5));
		p.add(new Triangle("Second Triangle", 4, 3));
		p.add(new Circle("First Circle", 5));
		p.add(new Circle("Second Circle", 10));
		p.add(new Square("First Square", 5));
		p.add(new Square("Second Square", 10));
		p.add(new Rectangle("First Rectangle", 4, 8));
		p.add(new Rectangle("Second Rectangle", 8, 4));
		System.out.println("Testing printShapes() and totalArea()...");
		p.printShapes();
		double totalArea = p.totalArea();
		System.out.printf("The total area is %.3f\n", totalArea);
		System.out.println("...printShapes() and totalArea() completed.");
		System.out.println("Testing drawAll()...");
		p.drawAll();
		System.out.println("...drawAll() completed.");
	}
}

