"""
CSV Cleaner and Pretty Printer for LeetCode Problems

This script:
1. Cleans the CSV file by:
   - Removing percentage signs from numeric columns
   - Converting strings to proper numeric values
   - Handling any malformed data
2. Displays the data in a beautiful, readable format
"""

import pandas as pd
import argparse
from tabulate import tabulate
from termcolor import colored

def clean_csv_data(df):
    """Clean and normalize the CSV data"""
    # Remove percentage signs from Acceptance column
    if 'Acceptance' in df.columns:
        df['Acceptance'] = df['Acceptance'].astype(str).str.replace('%', '').astype(float)
    
    # Clean other potential numeric columns
    numeric_cols = ['Frequency', 'ID']
    for col in numeric_cols:
        if col in df.columns:
            df[col] = pd.to_numeric(df[col], errors='coerce')
    
    return df

def apply_color(row):
    """Apply colors based on difficulty level"""
    if row['Difficulty'] == 'Easy':
        return colored(row['Difficulty'], 'green')
    elif row['Difficulty'] == 'Medium':
        return colored(row['Difficulty'], 'yellow')
    elif row['Difficulty'] == 'Hard':
        return colored(row['Difficulty'], 'red')
    return row['Difficulty']

def display_pretty_table(df, use_color=False, page_size=None):
    """Display the cleaned data in a pretty format"""
    # Create a copy for display
    display_df = df.copy()
    
    if use_color:
        display_df['Difficulty'] = display_df.apply(apply_color, axis=1)
    
    # Format numeric columns
    if 'Acceptance' in display_df.columns:
        display_df['Acceptance'] = display_df['Acceptance'].map('{:.1f}%'.format)
    if 'Frequency' in display_df.columns:
        display_df['Frequency'] = display_df['Frequency'].map('{:.3f}'.format)
    
    # Select columns to display
    display_cols = ['ID', 'Title', 'Acceptance', 'Difficulty', 'Frequency', 'Leetcode Question Link']
    display_cols = [col for col in display_cols if col in display_df.columns]
    
    # Create and display table
    table = tabulate(
        display_df[display_cols],
        headers='keys',
        tablefmt='fancy_grid',
        showindex=False,
        maxcolwidths=30
    )
    
    if page_size:
        lines = table.split('\n')
        header = lines[:3]
        rows = lines[3:]
        
        for i in range(0, len(rows), page_size):
            print('\n'.join(header + rows[i:i+page_size]))
            if i + page_size < len(rows):
                input("\nPress Enter for next page...")
    else:
        print(table)

def main():
    parser = argparse.ArgumentParser(description='Clean and pretty print LeetCode problems CSV')
    parser.add_argument('filename', help='Path to CSV file')
    parser.add_argument('--color', action='store_true', help='Enable color output')
    parser.add_argument('--page', type=int, help='Number of rows per page')
    
    args = parser.parse_args()
    
    try:
        # Read and clean the data
        df = pd.read_csv(args.filename)
        df = clean_csv_data(df)
        
        # Display the pretty table
        display_pretty_table(df, use_color=args.color, page_size=args.page)
        
    except Exception as e:
        print(f"Error processing file: {e}")
        print("Please check your CSV file format and try again.")

if __name__ == '__main__':
    main()