# k-Nearest Neighbors (kNN) Model: Project Overview

## What We Have Created
This project implements a **k-Nearest Neighbors (kNN)** classification algorithm in Java. The program reads data points from a CSV file, calculates distances between the test point and training data, and predicts a label based on the majority vote of the nearest neighbors.

This implementation is designed for learners, providing a clear and concise example of how kNN works, complete with methods for loading data, computing distances, and classifying points.

---

## What Is kNN?

**k-Nearest Neighbors (kNN)** is a supervised machine learning algorithm used for classification and regression tasks. It operates based on the principle that data points with similar features are likely to belong to the same category.

### Key Characteristics:
1. **Instance-based Learning:** kNN does not require a training phase. Instead, it uses the entire dataset to make predictions.
2. **Distance Metric:** Determines the similarity between data points, typically using metrics like Euclidean or Manhattan distance.
3. **Voting Mechanism:** For classification, the algorithm considers the majority label among the `k` nearest neighbors.

---

## How the Project Was Created

### 1. Planning the Implementation
Before diving into the code, the following decisions were made:

- **Data Representation:** A `DataPoint` class encapsulates the features (numerical values) and the label (category) for each data point.
- **Distance Metric:** Euclidean distance was chosen for measuring similarity.
- **Input and Output:** The program reads a CSV file as input and outputs the predicted label for a given test point.

### 2. Building the Core Components
The project was broken into several logical methods:

#### **a. Loading Data from a CSV File**
The `loadCSV` method reads data from a CSV file and converts it into a list of `DataPoint` objects. Each row in the file represents a data point, with numeric values for features and a string label.

```java
public static List<DataPoint> loadCSV(String filePath);
```
- **Key Feature:** Handles parsing and error-checking for the dataset.

#### **b. Calculating Distances**
The `calculateDistance` method computes the Euclidean distance between two points in a multi-dimensional space. This is essential for identifying the nearest neighbors.

```java
public static double calculateDistance(double[] point1, double[] point2);
```
- **Key Formula:**
   \[ \text{Distance} = \sqrt{\sum_{i=1}^{n}(x_i - y_i)^2} \]

#### **c. Classifying a Test Point**
The `classify` method:
- Computes the distance between the test point and all data points.
- Sorts data points by their distance to the test point.
- Selects the top `k` nearest neighbors and determines the most common label.

```java
public static String classify(List<DataPoint> dataPoints, double[] testPoint, int k);
```
- **Key Feature:** Uses a majority voting mechanism to decide the label.

### 3. Testing and Debugging

#### **Sample Dataset**
A sample dataset `fruits_data.csv` was created, containing features like size, weight, and color index for different fruits (e.g., Apple, Banana, Cherry).

#### **Test Cases**
Various test points were run through the model to verify:
- Correct distance calculations.
- Proper sorting and selection of neighbors.
- Accurate label predictions.

### 4. Enhancing Usability
The project includes:
- Customizable `k` values to experiment with different numbers of neighbors.
- Clear error messages for invalid inputs or file issues.
- Modularity to allow future enhancements, such as additional distance metrics.

---

## Key Takeaways
This project demonstrates how the kNN algorithm can be implemented in a practical and educational manner. By focusing on clean, modular code, this project provides a solid foundation for exploring machine learning concepts in Java.

