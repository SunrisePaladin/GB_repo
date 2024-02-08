#include <iostream>
using namespace std;

int main() {
	int numbers[] = { 2,5,13,7,6,4 };
	int index = 0, avg = 0, sum = 0, size = 6;
	while (index < size) {
		sum += numbers[index];
		index++;
	}
	avg = sum / size;
	cout << avg << endl;
	system("pause");
	return 0;
}