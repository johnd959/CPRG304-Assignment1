This file contains the instruction of installation and usage of the Sorting program.





## Installation


-- Make sure you have Java Runtime Environment (JRE) installed on your system. You can download it from Oracle's official website.

-- Download the 'sort.jar' file from the submission files.





## Usage



-- To run the program, open the command prompt and navigate to the directory where `sort.jar` is located.


-- Enter this command "java -jar sort.jar -f[file_path] -t[sorting_type] -s[sorting_algorithm]".


More detail about the given command:
	
** file_path: The path to the text file which contains the shapes data(Enclose the file path in quotes if it contains spaces.)

** sorting_type: Specify the sorting type(`v` for volume, `h` for height, or `a` for base area)

** sorting_algorithm: Specify the sorting algorithm 
  
  - `b` for Bubble Sort
  - `s` for Selection Sort
  - `i` for Insertion Sort
  - `m` for Merge Sort
  - `q` for Quick Sort
  - `z` for Heap Sort

** Examples of Valid Inputs:

- `java -jar sort.jar -f"polyfor1.txt" -tV -sB`
- `java -jar sort.jar -tA -sQ -f"res\\polyfor3.txt"`
- `java -jar sort.jar -tH -f"C:\\temp\\polyfor5.txt" -sB`

## Notes:

- The program is order and case insensitive. You can use upper or lower case for the command options.
- Make sure to provide valid file paths and file names with correct extensions.

