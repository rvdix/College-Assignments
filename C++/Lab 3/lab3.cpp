#include <iostream>
#include <string> 
#include <vector> 
#include <fstream>
#include <math.h> 
#include <sstream> 

using namespace std; 

class Matrix
{
    private: 
    vector <vector<int>> matrix; 
    int dimension; 

    public: 

    Matrix()
    {
    }

    Matrix(int size)
    {
        dimension = size; 
        matrix.resize(dimension);
        for (int i = 0; i < dimension; i++)
        {
            matrix[i].resize(dimension); 
        }
    }

    void setMatrix(int size, vector<int> &values)
    {
        dimension = size; 
        int counter = 0; 
        matrix.resize(dimension); 

        for (int i = 0; i < dimension; i++)
        {   
            matrix[i].resize(dimension); 
            
            for (int j = 0; j < dimension; j++)
            {
                matrix[i][j] = values[counter]; 
                counter++;
            }
        }
    }

    void printMatrix()
    {
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                cout << matrix[i][j] << " "; 
            }
            cout << endl; 
        }
    }

    friend Matrix operator+(Matrix &matrix1, Matrix &matrix2)
    {
        int length = matrix1.dimension;  
        int matrix1Num; 
        int matrix2Num; 
        Matrix summedMatrix(length);  

        for(int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                matrix1Num = matrix1.matrix[i][j]; 
                matrix2Num = matrix2.matrix[i][j]; 
                summedMatrix.matrix[i][j] = matrix1Num + matrix2Num; 
            }
        }
        return summedMatrix; 
    } 

    friend Matrix operator-(Matrix &matrix1, Matrix &matrix2)
    {
        int length = matrix1.dimension; 
        int matrix1Num;
        int matrix2Num;
        Matrix subtractedMatrix(length); 

        for (int i = 0; i < length; i++)
        {
            for(int j = 0; j < length; j++)
            {
                matrix1Num = matrix1.matrix[i][j]; 
                matrix2Num = matrix2.matrix[i][j]; 
                subtractedMatrix.matrix[i][j] = matrix1Num - matrix2Num; 
            }
        }
        return subtractedMatrix; 
    }

    friend Matrix operator* (Matrix &matrix1, Matrix &matrix2)
    {
        int length = matrix1.dimension; 
        Matrix multipliedMatrix(length); 
        int total; 
        int currentValue = 0; 

        for(int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
               for (int k = 0; k < length; k++)
               {
                   currentValue += matrix1.matrix[j][k] * matrix2.matrix[k][i]; 
               }
                multipliedMatrix.matrix[j][i] = currentValue; 
                currentValue = 0; 
            }
        }
        return multipliedMatrix; 
    }

    Matrix operator-- (int)
    {
        Matrix decrementedMatrix(dimension); 
        int currentValue; 

        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                currentValue = matrix[i][j]; 
                decrementedMatrix.matrix[i][j] = (currentValue - 1);  
            }
        }
        return decrementedMatrix; 
    }

    Matrix operator--()
    {
        Matrix decrementedMatrix(dimension); 
        int currentValue; 

        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                currentValue = matrix[i][j]; 
                decrementedMatrix.matrix[i][j] = (currentValue - 1);  
            }
        }
        return decrementedMatrix;         
    }

    Matrix operator++()
    {
        Matrix incrementedMatrix(dimension); 
        int currentValue; 

        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                currentValue = matrix[i][j]; 
                incrementedMatrix.matrix[i][j] = (currentValue + 1); 
            }
        }   
        return incrementedMatrix; 
    }

    Matrix operator++(int)
    {
        Matrix incrementedMatrix(dimension); 
        int currentValue; 

        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                currentValue = matrix[i][j]; 
                incrementedMatrix.matrix[i][j] = (currentValue + 1); 
            }
        }
        return incrementedMatrix; 
    }

    friend Matrix operator~(Matrix &matrix1)
    {
        Matrix transposedMatrix(matrix1.dimension);

        for(int i = 0; i < matrix1.dimension; i++)
        {
            for(int j = 0; j < matrix1.dimension; j++)
            {
                transposedMatrix.matrix[i][j] = matrix1.matrix[j][i]; 
            }
        }
        return transposedMatrix; 
    }

    friend Matrix operator^ (Matrix &matrix1, int exponent)
    {
        Matrix *exponentiated;
        Matrix *currentValue;  
        int length = matrix1.dimension; 

        for (int l = 0; l < exponent - 1; l++)
        {
            if (l == 0)
            {
                exponentiated = new Matrix(matrix1*matrix1); 
            }

            else
            {
                currentValue = exponentiated; 
                exponentiated = new Matrix((*exponentiated) * (matrix1)); 
                delete currentValue; 
            }
        }
        return *exponentiated; 
    }    

    friend ostream &operator<< (ostream &output, Matrix &matrix1)
    {
        for (int i = 0; i < matrix1.dimension; i++)
        {
            for (int j = 0; j < matrix1.dimension; j++)
            {
                output << matrix1.matrix[i][j] << " "; 
            }
            output << endl; 
        }
        return output; 
    }
};

int main() 
{
    Matrix userMatrix; 
    vector<int> values; 
    Matrix secondMatrix; 
    string currentNum; 
    string currentRow; 
    string operationChosen; 
    int exponential; 
    int size; 
    int operation = 0; 
    double counter = 0; 
    double combined; 
    double currentPower; 
    int test; 

    cout << "Please type in your matrix size: "; 
    cin >> size; 
 
    for (int j = 0; j < size; j++)
    {
        cout << "Type in the values for row " << j << ": "; 
        cin.clear();
        fflush(stdin);
        getline(cin, currentRow); 

        istringstream delimited(currentRow, istringstream::in); 

        while(delimited >> currentNum)
        {
            for (int i = currentNum.size() - 1; i > -1; i--)
            {
                test = currentNum[i] - 48; 
                if (currentNum[i] == '0')
                {
                    combined += 0; 
                    counter++; 
                    continue; 
                } 
                currentPower = test * pow(10.0, counter); 
                combined += (int)currentPower;
                counter++; 
            }
            values.push_back(combined); 
            counter = 0; 
            combined = 0; 
            currentNum.empty(); 
        }
    }

    userMatrix.setMatrix(size, values);
    cout << "Please enter the operation you wish to perform: "; 
    getline(cin, operationChosen); 
    for (int i; i < operationChosen.length(); i++ )
    {  
        if (isdigit(operationChosen[i])) 
        {
            operation = ((int)operationChosen[i]) - 48;
            break; 
        }
    }

    if(operation == 1 || operation == 2 || operation == 3 || operation == 4)
    {
        values.clear();

        for (int j = 0; j < size; j++)
        {
            cout << "Type in the values for row " << j << " of the second matrix: "; 
            cin.clear();
            fflush(stdin);
            getline(cin, currentRow); 

            istringstream delimited(currentRow, istringstream::in); 

            while(delimited >> currentNum)
            {
                for (int i = currentNum.size() - 1; i > -1; i--)
                {
                    test = currentNum[i] - 48; 
                    if (currentNum[i] == '0')
                    {
                        combined += 0; 
                        counter++; 
                        continue; 
                    } 
                    currentPower = test * pow(10.0, counter); 
                    combined += (int)currentPower;
                    counter++; 
                }
                values.push_back(combined); 
                counter = 0; 
                combined = 0; 
                currentNum.empty(); 
            }
        }
        secondMatrix.setMatrix(size, values);  
    }

    if(operation == 1)
    {
        Matrix newMatrix = userMatrix+secondMatrix; 
        cout << "Added matrices: " << endl; 
        cout << newMatrix; 
    }
    else if(operation == 2)
    {
        Matrix newMatrix = userMatrix - secondMatrix;
        cout << "Subtracted matrices: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 3)
    {
        Matrix newMatrix = (userMatrix * secondMatrix);
        cout << "Multiplied matrices: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 4)
    {
        
        Matrix newMatrix = userMatrix++;  
        cout << "Incremented matrix: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 5)
    {
        Matrix newMatrix = userMatrix--;
        cout << "Decremented matrices: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 6)
    {
        Matrix newMatrix = ~userMatrix;
        cout << "Transposed matrices: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 7)
    {
        cout << "Please choose the power to raise the matrix to: ";
        cin >> exponential; 
        Matrix newMatrix = (userMatrix^exponential); 
        cout << "Exponentiated matrices: " << endl; 
        cout << newMatrix;
    }
    else if(operation == 8)
    {
        cout << userMatrix; 
    }
}