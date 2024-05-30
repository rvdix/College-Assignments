#include <iostream>
#include <string>
using namespace std; 

int main()
{

    char token = '\0';
    string lastLetter;
    int counter;
    string countryName;
    bool skip = false;

    cout<< "Please enter the country name:"<<endl;
    getline(cin, countryName);

    if (countryName[0] == 'A' || countryName[0] == 'E' || countryName[0] == 'I' || countryName[0] == 'O' || countryName[0] == 'U')
    {
        cout<< "l'" << countryName << endl;
        skip = true;
    }

    if (countryName == "Belize"|| countryName == "Cambodge" || countryName == "Mexique" || countryName == "Mozambique" || countryName == "Zaïre" || countryName == "Zimbabwe")
    {   
        skip = true;
        cout<< "le " << countryName << endl;
        
    }

    

    if (skip == false)
    {
        for (int i = 0; i < 100; i++)
        {

            if (countryName[i+1] == token)
            {
                counter = i; 
                break;
            }

        }

        lastLetter = countryName[counter];
        
        if (lastLetter == "e")
        {
            cout<< "la " << countryName <<endl;

        }

        else if (lastLetter == "s")
        {
            cout<< "les " << countryName <<endl;
        }

        else
        {
            cout<< "le " <<countryName <<endl;
        }
        

    }

   


    return 0; 
}