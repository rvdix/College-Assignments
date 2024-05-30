#include <iostream>
#include <string>
#include <time.h> 
#include <random>
#include <algorithm>

using namespace std; 

struct Segment
{
    int trainStatus = 0; 
    struct Segment* prevSegment = NULL; 
    struct Segment* nextSegment = NULL; 
    struct Segment* adjacentSegment = NULL; 
};


int main()
{
    bool hasBeenMoved1; 
    bool hasBeenMoved2; 
    int counter = 0; 
    int randCount = 0; 
    int randomNum = 0; 
    int trainCounter = 0; 
    Segment initialSegment;
    Segment initialOuterSegment;  
    Segment *currentSegment; 
    Segment *previousSegment; 
    Segment *currentOuterSegment;
    vector <Segment *> previouslyMovedTrains; 
    currentSegment = &initialSegment;
    currentOuterSegment = &initialOuterSegment;

    srand(time(0)); 


    //initializing and setting the pointers for the inner track
    for(int i = 0; i < 10; i++)
    {
        currentSegment->nextSegment = new Segment; 
        previousSegment = currentSegment; 
        currentSegment = currentSegment->nextSegment; 
        currentSegment->prevSegment = previousSegment; 
        if (i == 9)
        {
            currentSegment->nextSegment = &initialSegment; 
            initialSegment.prevSegment = currentSegment; 
        }
    }

    //intializing and setter the pointer for the outer track 
    //TODO CHANGE TO OUTER SEGMENT VARIABLE
    currentOuterSegment = &initialOuterSegment; 
    for(int i = 0; i < 10; i++)
    {
        currentOuterSegment->nextSegment = new Segment; 
        previousSegment = currentOuterSegment; 
        currentOuterSegment = currentOuterSegment->nextSegment; 
        currentOuterSegment->prevSegment = previousSegment; 
        if (i == 9)
        {
            currentOuterSegment->nextSegment = &initialOuterSegment; 
            initialOuterSegment.prevSegment = currentOuterSegment; 
        }
    }


    //linking both tracks together
    currentSegment = &initialSegment; 
    currentOuterSegment = &initialOuterSegment; 

   for(int i = 0; i < 10; i++)
   {
        currentSegment->adjacentSegment = currentOuterSegment;
        currentOuterSegment->adjacentSegment = currentSegment; 
        currentSegment = currentSegment->nextSegment; 
        currentOuterSegment = currentOuterSegment->nextSegment; 
   }

   currentSegment = &initialSegment; 
   currentOuterSegment = &initialOuterSegment; 

    //adding trains to tracks
    while(counter < 4)
    {
        randomNum = (rand() % 2);
      
        if (randomNum == 1)
        {
            if (counter == 0)
            {
                currentSegment->trainStatus = -1; 
                counter++;
            }
            else if(counter == 1)
            {
                currentSegment->trainStatus = 1; 
                counter++; 
            }
            else if (counter == 2)
            {
                currentOuterSegment->trainStatus = -1; 
                counter++; 
            }
            else if (counter == 3)
            {
                currentOuterSegment->trainStatus = 1; 
                counter++; 
            }
        }

        currentSegment = currentSegment->nextSegment; 
        currentOuterSegment = currentOuterSegment->nextSegment; 
        
    }


    currentSegment = &initialSegment; 
    currentOuterSegment = &initialOuterSegment;

    for (int i = 0; i < 50; i++)
    {
        cout << endl << "Current stage: " << i+1 << endl; 
        //output for outer top track status
        cout << "+"; 
        for (int j = 0; j < 5; j++)
        {
            if(currentOuterSegment->trainStatus == 0)
            {
                cout << "----";
            }
            else if (currentOuterSegment->trainStatus == 1)
            {
                cout << "--->";
            }

            else if (currentOuterSegment->trainStatus == -1)
            {
                cout << "<---";
            }
            currentOuterSegment = currentOuterSegment->nextSegment; 
        }

        //output for inner top track status
        cout << "+" << endl; 
        cout << "|    x  x  x  x  x   |" << endl; 
        cout << "|  ";
        cout << "|";  
        
        for (int j = 0; j < 5; j++)
        {
            if (currentSegment->trainStatus == 0)
            {
                cout << "---"; 
            }
            else if (currentSegment->trainStatus == 1)
            {
                cout << "-->";
            }
            else if (currentSegment->trainStatus == -1)
            {
                cout << "<--"; 
            }
            currentSegment = currentSegment->nextSegment; 
        }
        cout << "|"; 
        cout << " |" << endl;
        cout << "|  |               | |" << endl;  
        cout << "|  |";
        //output for bottom inner track status
        for (int j = 0; j < 5; j++)
        {
            if (currentSegment->trainStatus == 0)
            {
                cout << "---"; 
            }
            else if (currentSegment->trainStatus == 1)
            {
                cout << "-->";
            }
            else if (currentSegment->trainStatus == -1)
            {
                cout << "<--"; 
            }
            currentSegment = currentSegment->nextSegment; 
        }
        cout << "| |" <<endl; 
        cout << "|    x  x  x  x  x   |" << endl; 
        cout << "+"; 
        //out for bottom outer track status
        for (int j = 0; j < 5; j++)
        {
            if(currentOuterSegment->trainStatus == 0)
            {
                cout << "----";
            }
            else if (currentOuterSegment->trainStatus == 1)
            {
                cout << "--->";
            }

            else if (currentOuterSegment->trainStatus == -1)
            {
                cout << "<---";
            }
            currentOuterSegment = currentOuterSegment->nextSegment; 
        }
        cout << "+";   

    
        currentSegment = &initialSegment; 
        currentOuterSegment = &initialOuterSegment; 
        trainCounter = 0; 
        //next train cycle 
        while(trainCounter < 4)
        {
            hasBeenMoved1 = (find(previouslyMovedTrains.begin(), previouslyMovedTrains.end(), currentSegment) != previouslyMovedTrains.end());
            hasBeenMoved2 = (find(previouslyMovedTrains.begin(), previouslyMovedTrains.end(), currentOuterSegment) != previouslyMovedTrains.end());

            if(currentSegment->trainStatus == 1 && !hasBeenMoved1)
            {
                if(currentSegment->nextSegment->trainStatus == 0)
                {
                    currentSegment->trainStatus = 0; 
                    currentSegment->nextSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentSegment->nextSegment); 
                    trainCounter++; 
                }

                else if (currentSegment->nextSegment->trainStatus == 1)
                {
                    currentSegment->trainStatus = 0; 
                    currentSegment->nextSegment->trainStatus = 1;   
                    currentSegment->nextSegment->nextSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentSegment->nextSegment); 
                    previouslyMovedTrains.push_back(currentSegment->nextSegment->nextSegment); 
                    trainCounter += 2; 
                }

                else if (currentSegment->nextSegment->trainStatus = -1)
                {
                    currentSegment->trainStatus = 0; 
                    if (currentSegment->adjacentSegment->trainStatus == 1 || currentSegment->adjacentSegment->trainStatus == -1)
                    {
                        currentSegment->adjacentSegment->prevSegment->trainStatus = -1; 
                        previouslyMovedTrains.push_back(currentSegment->adjacentSegment->prevSegment);
                        trainCounter++; 
                        break; 
                    }
                    currentSegment->adjacentSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentSegment->adjacentSegment); 
                    trainCounter++; 
                }
            }

            if(currentSegment->trainStatus == -1 && !hasBeenMoved1)
            {
                if (currentSegment->prevSegment->trainStatus == 0)
                {
                    currentSegment->trainStatus = 0; 
                    currentSegment->prevSegment->trainStatus = -1;
                    previouslyMovedTrains.push_back(currentSegment->prevSegment);
                    trainCounter++; 

                }

                else if (currentSegment->prevSegment->trainStatus == 1)
                {
                    currentSegment->trainStatus = 0; 
                    if (currentSegment->adjacentSegment->trainStatus == 1 || currentSegment->adjacentSegment->trainStatus == -1)
                    {
                        currentSegment->adjacentSegment->prevSegment->trainStatus = -1; 
                        previouslyMovedTrains.push_back(currentSegment->adjacentSegment->prevSegment); 
                        trainCounter++; 
                        break; 
                    }
                    currentSegment->adjacentSegment->trainStatus = -1; 
                    previouslyMovedTrains.push_back(currentSegment->adjacentSegment);
                    trainCounter++; 
                }

                else if (currentSegment->prevSegment->trainStatus == -1)
                {
                    currentSegment->trainStatus = 0; 
                    currentSegment->prevSegment->trainStatus = -1; 
                    currentSegment->prevSegment->prevSegment->trainStatus = -1; 
                    previouslyMovedTrains.push_back(currentSegment->prevSegment); 
                    previouslyMovedTrains.push_back(currentSegment->prevSegment->prevSegment);
                    trainCounter += 2; 

                }
            }

            if(currentOuterSegment->trainStatus == 1 && !hasBeenMoved2)
            {
                if(currentOuterSegment->nextSegment->trainStatus == 0)
                {
                    currentOuterSegment->trainStatus = 0; 
                    currentOuterSegment->nextSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentOuterSegment->nextSegment); 
                    trainCounter++; 
                }

                else if (currentOuterSegment->nextSegment->trainStatus == 1)
                {
                    currentOuterSegment->trainStatus = 0; 
                    currentOuterSegment->nextSegment->trainStatus = 1;   
                    currentOuterSegment->nextSegment->nextSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentOuterSegment->nextSegment); 
                    previouslyMovedTrains.push_back(currentOuterSegment->nextSegment->nextSegment); 
                    trainCounter += 2; 
                }

                else if (currentOuterSegment->nextSegment->trainStatus = -1)
                {
                    currentOuterSegment->trainStatus = 0; 
                    if (currentOuterSegment->adjacentSegment->trainStatus == 1 || currentOuterSegment->adjacentSegment->trainStatus == -1)
                    {
                        currentOuterSegment->adjacentSegment->prevSegment->trainStatus = 1; 
                        previouslyMovedTrains.push_back(currentOuterSegment->adjacentSegment->prevSegment); 
                        trainCounter++; 
                        break; 
                    }
                    currentOuterSegment->adjacentSegment->trainStatus = 1; 
                    previouslyMovedTrains.push_back(currentOuterSegment->adjacentSegment); 
                    trainCounter++; 
                }
            }
         
            if(currentOuterSegment->trainStatus == -1 && !hasBeenMoved2)
            {
                if (currentOuterSegment->prevSegment->trainStatus == 0)
                {
                    currentOuterSegment->trainStatus = 0; 
                    currentOuterSegment->prevSegment->trainStatus = -1;
                    previouslyMovedTrains.push_back(currentOuterSegment->prevSegment);
                    trainCounter++; 

                }

                else if (currentOuterSegment->prevSegment->trainStatus == 1)
                {
                    currentOuterSegment->trainStatus = 0; 
                    if (currentOuterSegment->adjacentSegment->trainStatus == 1 || currentOuterSegment->adjacentSegment->trainStatus == -1)
                    {
                        currentOuterSegment->adjacentSegment->prevSegment->trainStatus = 1; 
                        previouslyMovedTrains.push_back(currentOuterSegment->adjacentSegment->prevSegment); 
                        trainCounter++; 
                        break; 

                    }
                    currentOuterSegment->adjacentSegment->trainStatus = -1; 
                    previouslyMovedTrains.push_back(currentOuterSegment->adjacentSegment);
                    trainCounter++; 
                }

                else if (currentOuterSegment->prevSegment->trainStatus == -1)
                {
                    currentOuterSegment->trainStatus = 0; 
                    currentOuterSegment->prevSegment->trainStatus = -1; 
                    currentOuterSegment->prevSegment->prevSegment->trainStatus = -1; 
                    previouslyMovedTrains.push_back(currentOuterSegment->prevSegment); 
                    previouslyMovedTrains.push_back(currentOuterSegment->prevSegment->prevSegment);
                    trainCounter += 2; 
                }

            }

            currentSegment = currentSegment->nextSegment;
            currentOuterSegment = currentOuterSegment->nextSegment;  
        }    
        previouslyMovedTrains.clear(); 
    }
}