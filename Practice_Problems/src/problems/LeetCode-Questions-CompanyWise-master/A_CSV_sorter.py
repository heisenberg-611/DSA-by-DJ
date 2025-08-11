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