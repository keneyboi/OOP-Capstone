
# Discrete Calculator

 A Java project that allows users to calculate common **Discrete Structures 2** formulas
quickly: **Combination**, **Permutation**, **Bernoulli**, **Binomial Distribution**, and **Hypergeometric Distribution**.

It makes use of **JSwing** to give users a quick and easy-to-use user interface. It includes features of such as **Calculation**, **Derivation**, and shows **History**. It also includes **filtering** of past
equations and arrangement via when created.
 
----------------------------------------------------------------------------

### Class Name: Equation -> Abstract -> Implements Comparable<Equation>
#### Fields: 
- Result (double)
- Type (String)
- creationTime (Instant)

#### Constructor:
public Equation(String t) -> sets Type to t & Result to 0;

#### Methods: 
- Pu	Instant getCreationTime();
- Pu	String getType(); -> getter
- Pu	double getResult(); -> getter
- Pu	int compareTo(Equation other)
- A		double computeResult();
- A 	double derive(String var);
- A		JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: Combination -> extends Equation

#### Fields: 
- n (double);
- r (double);

#### Constructor:
public Combination(double n, double r) -> calls parent constructor;

#### Methods: 
- Pu 	double computeResult();
- Pu 	double derive(String var);
- Pu 	JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: Permutation -> extends Equation

#### Fields: 
- n (double);
- r (double);

#### Constructor:
public Permutation(double n, double r) -> calls parent constructor;

#### Methods: 
- Pu	double computeResult();
- Pu	double derive(String var);
- Pu	JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: Bernoulli -> extends Equation

#### Fields: 
- n (double);
- k (double);
- q (double);
- p (double);


#### Constructor:
public Bernoulli(double n, double k, double q, double p) -> calls parent constructor;

#### Methods: 
- Pu	double computeResult();
- Pu	double derive(String var);
- Pu	JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: Binomial -> extends Bernoulli

#### Constructor:
public Binomial(double n, double k, double q, double p) -> calls parent constructor;

#### Methods: 
- Pu	double computeResult();
- Pu	double derive(String var);
- Pu	JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: Hypergeometric -> extends Equation

#### Fields: 
- n (double); 
- k (double);
- r (double);
- m (double);

#### Constructor:
public Hypergeometric(double n, double k, double r, double m) -> calls parent constructor;

#### Methods: 
- Pu	double computeResult();
- Pu	double derive(String var);
- Pu	JPanel getPanel(); 


----------------------------------------------------------------------------

### Class Name: DiscreteCalculatorGUI -> extends JFrame

#### Private Fields: 
- currentFile (String)
- equationHistory (ArrayList<Equation>);
- ---> JSwing Components Here <---

#### Constructor:
public DiscreteCalculator();

#### Methods: 
- Pr	void updateScrollPane();
- Pr	void paint(BackgroundPanel bp);
- Pr	ArrayList<Equation> loadFromFile(String filename); 
- Pr	String saveToFile(String filename); 


----------------------------------------------------------------------------

### Class Name: BackgroundPanel -> extends JComponent 

#### Private Fields: 
- backgroundImage (BufferedImage);
	
#### Constructor:
public BackgroundPanel(String ImagePath);

#### Methods: 
- Prot.	void paintComponent();


----------------------------------------------------------------------------

### Class Name: InvalidCalculationException -> extends Exception 
	
#### Constructor:
public InvalidCalculationException(String message) -> calls parent constructor


----------------------------------------------------------------------------

### Class Name: ArrangeName -> implements Comparator<Equation>
	
#### Method:
- pu	int compare(Equation e1, Equation e2);


----------------------------------------------------------------------------







