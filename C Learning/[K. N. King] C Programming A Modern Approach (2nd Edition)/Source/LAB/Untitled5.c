void readFile(){
   	printf("Enter name of a file you wish to see\n");
   	gets(source_file);
   	source = fopen(source_file, "r");
   	if (source == NULL){
      	perror("Error while opening the file.\n");
}
   	printf("The contents of %s file are:\n", source_file);
   	while((ch = fgetc(source)) != EOF)
    	printf("%c", ch);
   	fclose(source);
}

void copyFile(){
   printf("Enter name of file to copy\n");
   gets(source_file);
   source = fopen(source_file, "r");
   if (source == NULL){
      printf("Press any key to exit...\n");
   }
   printf("Enter name of target file\n");
   gets(target_file);
   target = fopen(target_file, "w");
   if (target == NULL){
      fclose(source);
      printf("Press any key to exit...\n");
   }
   while ((ch = fgetc(source)) != EOF)
      fputc(ch, target);
   printf("File copied successfully.\n");
   fclose(source);
   fclose(target);
}

void mergeFile(){
   printf("Enter name of first file\n");
   gets(file1);

   printf("Enter name of second file\n");
   gets(file2);

   printf("Enter name of file which will store contents of the two files\n");
   gets(file3);

   fs1 = fopen(file1, "r");
   fs2 = fopen(file2, "r");

   if(fs1 == NULL || fs2 == NULL){
      perror("Error ");
      printf("Press any key to exit...\n");
   }

   ft = fopen(file3, "w"); // Opening in write mode

   if(ft == NULL)
   {
      perror("Error ");
      printf("Press any key to exit...\n");
   }

   while((ch = fgetc(fs1)) != EOF)
      fputc(ch,ft);

   while((ch = fgetc(fs2)) != EOF)
      fputc(ch,ft);

   printf("The two files were merged into %s file successfully.\n", file3);

   fclose(fs1);
   fclose(fs2);
   fclose(ft);
}

void deleteFile(){
  printf("Enter name of a file you wish to delete\n");
  gets(source_file);

  status = remove(source_file);

  if (status == 0)
    printf("%s file deleted successfully.\n", source_file);
  else{
    printf("Unable to delete the file\n");
    perror("Following error occurred");
  }
}
