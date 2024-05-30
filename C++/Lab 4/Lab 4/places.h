#include <iostream> 
#include <utility>

#define XLIM 2000
#define YLIM 2000

class Place
{
    private: 
    int x,y; 
    Place *N, *S, *E, *W; 
    char direction; 
    Vehicle *veh; 

    public: 

    //default constructor for Place
    Place()
    {
        N = NULL; 
        S = NULL; 
        E = NULL; 
        W = NULL; 
        veh = NULL; 
        direction = '0'; 

        x=y=-1; 
    }
    
    //constructor for place
    Place (int inX, int inY, char inDir)
    {
        N = S = W = E = NULL; 
        veh = NULL; 
        x = inX; 
        y = inY;
        direction = inDir; 

    }

    //allows user to set direction
    void setDirection (char inDirection)
    {
        direction = inDirection; 
    } 

    //allows user to set location
    void setLocation (int inX, int inY)
    {
        x = inX; 
        y = inY; 
    }

    //gets the direction and returns a char
    char getDirection() const
    {
        return direction; 
    }
    
    //returns location as a pair
    std::pair<int, int> getLocation()
    {
        std::pair <int, int> location; 
        location.first = x; 
        location.second = y; 
        return location; 
    }

    bool isFreeForward(char inDir) const
    {
        Place *temp; 
        if (inDir == 'N')
        {
            temp = N; 
        }
        else if (inDir == 'S')
        {
            temp = S;
        }
        else if (inDir == 'E')
        {
            temp = E;
        }
        else if (inDir == 'W')
        {
            temp = W;
        }

        if (temp != NULL)
        {
            return temp->isFreeToMove(); 
        }

        else
            return false; 
    }

    //checks if a vehicle is at an intersection
    bool isAtIntersection() const
    {
        int count = 0; 

        if (N != NULL)
        {
            count++; 
        }

        if (S != NULL)
        {
            count++; 
        }
        
        if (E != NULL)
        {
            count++; 
        }

        if (W != NULL)
        {
            count++; 
        }

        return count >= 2; 
    }

    //checks is the vehicle is free to move
    bool isFreeToMove() const
    {
        return veh == NULL; 
    }

    //sets the vehicle
    void setVehicle (Vehicle *inVehicle)
    {
        veh = inVehicle; 
    }

    //returns vehicle object
    Vehicle *getVehicle() const
    {
        return veh; 
    }

    void setPlace(Place *inPlace, char inDir)
    {
        if (inDir == 'N')
        {
            N = inPlace; 
        }
        if (inDir == 'S')
        {
            S = inPlace; 
        }
        if (inDir == 'E')
        {
            E = inPlace; 
        }
        else 
            W = inPlace; 
    }

    Place *getPlace(char inDir) const
    {

        if (inDir == 'N')
        {
            return N;
        }
        else if (inDir == 'S')
        {
            return S;
        }
        else if (inDir == 'E')
        {
            return E;
        }
        else
            return W; 
    }
};