#include <iostream> 
#include <vector> 

#define XLIM 2000
#define YLIM 2000
#define STEP 1


class Road
{

    private: 
    std::vector <Place *> lane; 
    char direction; 


    public: 
    Road()
    {
        direction = 'u'; 
    }
    Road (char inDir)
    {
        direction = inDir;
        buildRoad(); 
    }

    void setDirection (char inDir)
    {
        direction = inDir; 
    }

    char getDirection() const
    {
        return direction; 
    }

    Place *getRoadStart() const
    {
        return lane[0];
    }
    Place *getRoadEnd() const
    {
        return lane[lane.size() - 1];
    }

    std::vector<Place *> getlane() const
    {
        return lane; 
    } 

    void buildRoad()
    {
        int xloc = -1, yloc = -1; 
        if (direction == 'N')
        {
            xloc = XLIM/2+1; 
        }
        else if (direction == 'S')
        {
            xloc = XLIM/2; 
        }
        else if (direction == 'E')
        {
            yloc = YLIM/2; 
        }
       else
           yloc = YLIM/2+1; 
       
    }
    Place *getPlacefromLocation(int inX, int inY)
    {

    }
    std::pair<int, int> getLocationOfPlace(Place *) const
    {

    }
    

};