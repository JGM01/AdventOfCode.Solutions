#include <fstream>
#include <string>
#include <iostream>
#include <vector>
#include <sstream>


auto getFileContents(std::string f) 
{
    std::vector<std::string> v;
    std::ifstream file(f.c_str());

    std::string str;
    while (std::getline(file,str)) 
        v.push_back(str);
    
    file.close();
    return v;
}

auto ConvertToIntVector(std::vector<std::string> l)
{
    std::vector<int> v;

    int x;
    for (int i = 0; i < l.size(); i++)
    {
        std::stringstream str(l[i]);
        str >> x;
        v.push_back(x);
    }
    return v;
}

const std::vector<std::string> fileInput = getFileContents("A:/AOCINPUTS/day01.txt");

auto PartOne() {

    auto v = ConvertToIntVector(fileInput);

    int bigger = 0;
    for (int i = 1; i < v.size(); i++) 
        if (v[i] > v[i - 1]) bigger++;
    
    return bigger;
}
auto PartTwo() {

    auto v = ConvertToIntVector(fileInput);

    int bigger = 0;
    for (int i = 3; i < v.size(); i++)
        if (v[i - 2] + v[i - 1] + v[i] > v[i - 3] + v[i - 2] + v[i - 1])
            bigger++;
    
    return bigger;
}

int main()
{
    std::cout << PartOne() << std::endl;
    std::cout << PartTwo() << std::endl;
}