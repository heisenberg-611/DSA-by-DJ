"""
Backup File Organizer

This script finds all files in the current directory containing 'backup' in their filename
and moves them to a dedicated backup folder. If the folder doesn't exist, it will be created.

Usage:
    python organize_backups.py [--keyword KEYWORD] [--dry-run]

Options:
    --keyword KEYWORD  Use a different keyword instead of 'backup' [default: backup]
    --dry-run          Show what would be moved without actually moving files
"""

import os
import shutil
import argparse

def organize_backup_files(keyword='backup', dry_run=False):
    """
    Move files containing the keyword to a backup folder.
    
    Args:
        keyword (str): Keyword to search for in filenames
        dry_run (bool): If True, only show what would be moved
    """
    # Create backup directory if it doesn't exist
    backup_dir = 'backup_files'
    if not dry_run and not os.path.exists(backup_dir):
        os.makedirs(backup_dir)
        print(f"Created backup directory: {backup_dir}")
    
    # Find all files containing the keyword
    moved_files = 0
    for filename in os.listdir('.'):
        if keyword.lower() in filename.lower() and os.path.isfile(filename):
            dest_path = os.path.join(backup_dir, filename)
            
            if dry_run:
                print(f"[Dry Run] Would move: {filename} -> {dest_path}")
            else:
                try:
                    shutil.move(filename, dest_path)
                    print(f"Moved: {filename} -> {dest_path}")
                    moved_files += 1
                except Exception as e:
                    print(f"Error moving {filename}: {e}")
    
    # Print summary
    action = "Would be moved" if dry_run else "Moved"
    print(f"\n{action} {moved_files} files containing '{keyword}' to {backup_dir}/")

def main():
    parser = argparse.ArgumentParser(description='Organize backup files into a dedicated folder.')
    parser.add_argument('--keyword', default='backup',
                       help='Keyword to search for in filenames [default: backup]')
    parser.add_argument('--dry-run', action='store_true',
                       help='Show what would be moved without actually moving files')
    
    args = parser.parse_args()
    
    organize_backup_files(keyword=args.keyword, dry_run=args.dry_run)

if __name__ == '__main__':
    main()