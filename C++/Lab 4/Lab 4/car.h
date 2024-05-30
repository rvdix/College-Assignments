#include <iostream> 
#include <math.h> 
#include <time.h> 
#include <utility>
#include <string>  

class Car: public Vehicle
{

    private:
    std::string color; 
    class Place; 
    char direction; 
    Place* front; 
    Place* back; 


    public: 

    Car()
    {
        direction = '0'; 
        color = setColor(); 
        front = NULL; 
        back = NULL; 
    }

    std::string setColor()
    {
        srand(time(0));
        int selectedCol = rand()%12; 
        std::string randColor; 
    
        switch (selectedCol)
        {
            case 0:
                randColor = "black";
                break;
            case 1:
                randColor = "red";
                break;    
            case 2:
                randColor = "white"; 
                break;
            case 3:
                randColor = "yellow"; 
                break;
            case 4:
                randColor = "green"; 
                break;
            case 5:
                randColor = "blue"; 
                break;
            case 6:
                randColor = "orange"; 
                break;
            case 7:
                randColor = "purple"; 
                break;
            case 8:
                randColor = "grey"; 
                break;
            case 9:
                randColor = "lime"; 
                break;
            case 10:
                randColor = "teal";
                break;
            case 11:
                randColor = "burgundy"; 
                break;
            default:
                break;
        }
        return randColor; 
    }
    
    void repaintCar(int newColor)
    {
        switch (newColor)
        {
            case 0:
                color = "black";
                break;
            case 1:
                color = "red";
                break;
            case 2:
                color = "white";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "green";
                break;
            case 5:
                color = "blue";
                break;
            case 6:
                color = "orange";
                break;
            case 7:
                color = "purple";
                break;
            case 8:
                color = "grey";
                break;
            case 9:
                color = "lime";
                break;
            case 10:
                color = "teal";
                break;
            case 11:
                color = "burgundy";
                break;
            default:
                break;
        }
    }
};