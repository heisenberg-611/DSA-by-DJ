"""
import pandas as pd
import argparse

def sort_leetcode_problems(csv_file, sort_by='id', keyword=None, ascending=True):
    # Read the CSV file
    df = pd.read_csv(csv_file)
    
    # Filter by keyword if provided
    if keyword:
        keyword = keyword.lower()
        mask = (df['Title'].str.lower().str.contains(keyword)) | \
               (df['Leetcode Question Link'].str.lower().str.contains(keyword))
        df = df[mask]
    
    # Sort the dataframe
    if sort_by.lower() == 'id':
        df = df.sort_values('ID', ascending=ascending)
    elif sort_by.lower() == 'title':
        df = df.sort_values('Title', ascending=ascending)
    elif sort_by.lower() in ['acceptance', 'acceptancerate']:
        df = df.sort_values('Acceptance', ascending=ascending)
    elif sort_by.lower() in ['difficulty', 'level']:
        # Order the difficulty levels
        difficulty_order = {'Easy': 1, 'Medium': 2, 'Hard': 3}
        df['Difficulty_Num'] = df['Difficulty'].map(difficulty_order)
        df = df.sort_values('Difficulty_Num', ascending=ascending)
        df = df.drop('Difficulty_Num', axis=1)
    elif sort_by.lower() in ['frequency', 'freq']:
        df = df.sort_values('Frequency', ascending=ascending)
    else:
        print(f"Invalid sort_by option: {sort_by}. Defaulting to ID.")
        df = df.sort_values('ID', ascending=True)
    
    return df

def main():
    parser = argparse.ArgumentParser(description='Sort LeetCode problems from a CSV file.')
    parser.add_argument('csv_file', help='Path to the CSV file containing LeetCode problems')
    parser.add_argument('--sort', default='id', 
                        help='Sort by: id, title, acceptance, difficulty, frequency')
    parser.add_argument('--keyword', default=None, 
                        help='Filter problems by keyword in title or URL')
    parser.add_argument('--descending', action='store_true',
                        help='Sort in descending order')
    
    args = parser.parse_args()
    
    sorted_df = sort_leetcode_problems(
        args.csv_file, 
        sort_by=args.sort, 
        keyword=args.keyword,
        ascending=not args.descending
    )
    
    # Print the sorted dataframe
    print(sorted_df.to_string(index=False))
    
    # Option to save to new CSV
    save = input("\nDo you want to save this to a new CSV file? (y/n): ").lower()
    if save == 'y':
        output_file = input("Enter output filename (e.g., sorted_problems.csv): ")
        sorted_df.to_csv(output_file, index=False)
        print(f"Saved to {output_file}")

if __name__ == '__main__':
    main()


LeetCode Problem Sorter

This script helps sort and filter LeetCode problems from a CSV file based on various criteria
like difficulty, acceptance rate, frequency, or keywords. The results can be displayed in
the console or saved to a new CSV file.

Features:
- Sort by: ID, Title, Acceptance Rate, Difficulty, or Frequency
- Filter by keyword in title or URL
- Sort in ascending or descending order
- Option to save results to a new CSV file

CSV File Requirements:
The input CSV should contain these columns (case-sensitive):
- ID: Problem ID
- Title: Problem title
- Acceptance: Acceptance rate percentage
- Difficulty: Easy/Medium/Hard
- Frequency: Frequency value
- Leetcode Question Link: Problem URL

Usage:
    python sort_leetcode.py <csv_file> [--sort CRITERIA] [--keyword KEYWORD] [--descending]

Arguments:
    csv_file      Path to the CSV file containing LeetCode problems

Options:
    --sort CRITERIA   Sort by: id, title, acceptance, difficulty, frequency [default: id]
    --keyword KEYWORD Filter problems by keyword in title or URL
    --descending      Sort in descending order

Examples:
    1. Basic sort by problem ID:
       python sort_leetcode.py problems.csv

    2. Sort by difficulty (hardest first):
       python sort_leetcode.py problems.csv --sort difficulty --descending

    3. Find all array problems sorted by acceptance rate:
       python sort_leetcode.py problems.csv --sort acceptance --keyword array

    4. Save results to new file:
       python sort_leetcode.py problems.csv --sort frequency
       # When prompted, enter 'y' and provide output filename

Functions:
    sort_leetcode_problems(csv_file, sort_by, keyword, ascending):
        Main function that reads, filters and sorts the problems
        
        Parameters:
            csv_file (str): Path to input CSV file
            sort_by (str): Sorting criteria
            keyword (str): Optional filter keyword
            ascending (bool): Sort order
        
        Returns:
            pandas.DataFrame: Sorted and filtered problems

    main():
        Handles command-line arguments and user interaction
"""


"""
LeetCode Problem Sorter and Modifier

This script helps sort, filter, and modify LeetCode problems from a CSV file based on various criteria
like difficulty, acceptance rate, frequency, or keywords. The results can be displayed in
the console, saved to a new CSV file, or used to update the original file.

Features:
- Sort by: ID, Title, Acceptance Rate, Difficulty, or Frequency
- Filter by keyword in title or URL
- Sort in ascending or descending order
- Option to save results to a new CSV file
- Option to update the original CSV file

CSV File Requirements:
The input CSV should contain these columns (case-sensitive):
- ID: Problem ID
- Title: Problem title
- Acceptance: Acceptance rate percentage
- Difficulty: Easy/Medium/Hard
- Frequency: Frequency value
- Leetcode Question Link: Problem URL

Usage:
    python sort_leetcode.py <csv_file> [--sort CRITERIA] [--keyword KEYWORD] [--descending] [--update]

Arguments:
    csv_file      Path to the CSV file containing LeetCode problems

Options:
    --sort CRITERIA   Sort by: id, title, acceptance, difficulty, frequency [default: id]
    --keyword KEYWORD Filter problems by keyword in title or URL
    --descending      Sort in descending order
    --update          Update the original file with sorted results (use with caution)

Examples:
    1. Basic sort by problem ID:
       python sort_leetcode.py problems.csv

    2. Sort by difficulty (hardest first) and update original file:
       python sort_leetcode.py problems.csv --sort difficulty --descending --update

    3. Find all array problems sorted by acceptance rate and save to new file:
       python sort_leetcode.py problems.csv --sort acceptance --keyword array
       # When prompted, enter 'y' and provide output filename

    4. Update original file without sorting (just clean up):
       python sort_leetcode.py problems.csv --update

Functions:
    sort_leetcode_problems(csv_file, sort_by, keyword, ascending):
        Main function that reads, filters and sorts the problems
        
        Parameters:
            csv_file (str): Path to input CSV file
            sort_by (str): Sorting criteria
            keyword (str): Optional filter keyword
            ascending (bool): Sort order
        
        Returns:
            pandas.DataFrame: Sorted and filtered problems

    update_original_file(csv_file, df):
        Updates the original CSV file with the provided DataFrame
        
        Parameters:
            csv_file (str): Path to original CSV file
            df (pd.DataFrame): DataFrame with updated/sorted data

    main():
        Handles command-line arguments and user interaction
"""

import pandas as pd
import argparse
import os

def sort_leetcode_problems(csv_file, sort_by='id', keyword=None, ascending=True):
    """
    Read, filter and sort LeetCode problems from a CSV file.
    
    Args:
        csv_file (str): Path to the CSV file
        sort_by (str): Field to sort by (id/title/acceptance/difficulty/frequency)
        keyword (str): Optional keyword to filter problems
        ascending (bool): Sort in ascending order if True
        
    Returns:
        pd.DataFrame: Sorted and filtered DataFrame
    """
    # Read the CSV file
    df = pd.read_csv(csv_file)
    
    # Filter by keyword if provided
    if keyword:
        keyword = keyword.lower()
        mask = (df['Title'].str.lower().str.contains(keyword)) | \
               (df['Leetcode Question Link'].str.lower().str.contains(keyword))
        df = df[mask]
    
    # Sort the dataframe
    if sort_by.lower() == 'id':
        df = df.sort_values('ID', ascending=ascending)
    elif sort_by.lower() == 'title':
        df = df.sort_values('Title', ascending=ascending)
    elif sort_by.lower() in ['acceptance', 'acceptancerate']:
        df = df.sort_values('Acceptance', ascending=ascending)
    elif sort_by.lower() in ['difficulty', 'level']:
        # Order the difficulty levels
        difficulty_order = {'Easy': 1, 'Medium': 2, 'Hard': 3}
        df['Difficulty_Num'] = df['Difficulty'].map(difficulty_order)
        df = df.sort_values('Difficulty_Num', ascending=ascending)
        df = df.drop('Difficulty_Num', axis=1)
    elif sort_by.lower() in ['frequency', 'freq']:
        df = df.sort_values('Frequency', ascending=ascending)
    else:
        print(f"Invalid sort_by option: {sort_by}. Defaulting to ID.")
        df = df.sort_values('ID', ascending=True)
    
    return df

def update_original_file(csv_file, df):
    """
    Update the original CSV file with the sorted/filtered DataFrame.
    
    Args:
        csv_file (str): Path to the original CSV file
        df (pd.DataFrame): DataFrame with updated data
        
    Returns:
        bool: True if update was successful, False otherwise
    """
    try:
        # Create a backup of the original file
        backup_file = csv_file.replace('.csv', '_backup.csv')
        os.rename(csv_file, backup_file)
        print(f"Created backup of original file at: {backup_file}")
        
        # Save the updated DataFrame to the original file path
        df.to_csv(csv_file, index=False)
        print(f"Successfully updated original file at: {csv_file}")
        return True
    except Exception as e:
        print(f"Error updating file: {e}")
        return False

def main():
    """Handle command-line arguments and execute the sorting operation."""
    parser = argparse.ArgumentParser(description='Sort and modify LeetCode problems from a CSV file.')
    parser.add_argument('csv_file', help='Path to the CSV file containing LeetCode problems')
    parser.add_argument('--sort', default='id', 
                       help='Sort by: id, title, acceptance, difficulty, frequency')
    parser.add_argument('--keyword', default=None, 
                       help='Filter problems by keyword in title or URL')
    parser.add_argument('--descending', action='store_true',
                       help='Sort in descending order')
    parser.add_argument('--update', action='store_true',
                       help='Update the original file with sorted results')
    parser.add_argument('--quiet', action='store_true',
                   help='Suppress output printing to terminal')
    
    args = parser.parse_args()
    
    # Check if file exists
    if not os.path.exists(args.csv_file):
        print(f"Error: File not found - {args.csv_file}")
        return
    
    sorted_df = sort_leetcode_problems(
        args.csv_file, 
        sort_by=args.sort, 
        keyword=args.keyword,
        ascending=not args.descending
    )
    
    # Print the sorted dataframe unless quiet mode is enabled
    if not args.quiet:
        print(sorted_df.to_string(index=False))
    
     # Print the sorted dataframe unless quiet mode is enabled
    if not args.quiet:
        print(sorted_df.to_string(index=False))
    
    # Handle file operations
    if args.update:
        if not args.quiet:
            confirm = input("\nWARNING: This will modify the original file. Continue? (y/n): ").lower()
        else:
            confirm = 'y'  # Auto-confirm in quiet mode
            
        if confirm == 'y':
            success = update_original_file(args.csv_file, sorted_df)
            if not args.quiet and success:
                print("File updated successfully")
    else:
        if not args.quiet:
            save = input("\nDo you want to save this to a new CSV file? (y/n): ").lower()
            if save == 'y':
                output_file = input("Enter output filename (e.g., sorted_problems.csv): ")
                sorted_df.to_csv(output_file, index=False)
                print(f"Saved to {output_file}")
        else:
            # In quiet mode, default to not saving unless --update was specified
            pass

if __name__ == '__main__':
    main()