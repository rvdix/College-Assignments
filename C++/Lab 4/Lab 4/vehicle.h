#include <utility>

class Vehicle
{
    private: 
    std::pair <int, int> location; 
    int speed; 
    int weight; 

    public: 
        Vehicle()
        {
            location.first = 0;
            location.second = 0;
            speed = 0;
            weight = 0;
        }
};