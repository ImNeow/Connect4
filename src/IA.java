import javax.swing.JButton;

public class IA {
		
		private int choixIAdef =7 ;
		private int choixIAatt =7 ;
		private int choixIAfinal =7 ;

		
		
	public IA(int tableaunbr[][], JButton col1, JButton col2, JButton col3, JButton col4, JButton col5, JButton col6, JButton col7, int diff,int compt,int nbIA){	
		
		int i,j,l, typedef=10, typeatt=10,compteur =0;
		//i:lignes
		//j:colonnes
		
		int k[] = new int[7];
		//tableau contenant les colonnes qu'il ne faut pas choisir
		
		
		//Les typedef et typeatt sont les degrés de 'danger' d'un choix de l'IA ;
		// une typedef 1 = l'ennemi peut gagner si l'IA ne fait rien , typedef 3 serait plus une prévision au cas ou 
		//pareil pour les attaque , typeatt 1 = L'IA peut gagner en 1 coup , typeatt 3 est une prévision etc...
		
		/*
	j = 0 1 2 3 4 5 6	 i
						 =
	->	0 0 0 0 0 0 0    0 
		0 0 0 0 0 0 0    1
		0 0 0 0 0 0 0    2
		0 0 0 0 0 0 0    3
		0 0 0 0 0 0 0    4
		0 0 0 0 0 0 0    5
		
		
		tableaunbr[i][j]
		
		
		
		
		à faire :
	
		
		*/
		
		
		//COLONNE PLEINE 
		//L'IA regarde les colonnes pleines et les exclu de ses choix possibles 
		for(j=0;j<7;j++)
		{
			if(tableaunbr[0][j]!=0)
			{
				k[j]=1;
			}	
		}
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//DEFENSE
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				if(tableaunbr[i][j]==1)
				{
					
					//Niveau 1

					
				/*
				 * HORIZONTAL
				 */
					
					if(j<6 && tableaunbr[i][j+1]==1)
					{
						if(j<5 && tableaunbr[i][j+2]==1)
						{
							if(j<4 && tableaunbr[i][j+3]!=2 && i == 5 && choixIAdef == 7) // 1 1 1 0 
							{
									choixIAdef=j+3;
									typedef=1;
									System.out.println("Defense Horizontal +  i==5     1 1 1 0");
													
							}
							for(l=0;l<7;l++)
							{
							 if( k[l]==1 && choixIAdef==l && typedef !=1)
							 {
								 choixIAdef=7;
								 typedef=10;
								 System.out.println("DefReset");
							 }
							}
							
							
							if(j<4 && i<5 && tableaunbr[i+1][j+3]!=0 && tableaunbr[i][j+3]!=2 &&  choixIAdef ==7)
							{
									choixIAdef=j+3;
									typedef=1;
									System.out.println("Defense Horizontal +  i!=5     1 1 1 0");
													
							}
							if(j<4 && i==4 && tableaunbr[i+1][j+3]==0 && tableaunbr[i][j+3]!=2)
							{
									k[j+3]=1;													
							}
							if(j<4 && i<4 && tableaunbr[i+1][j+3]==0 && tableaunbr[i][j+3]!=2 &&tableaunbr[i+2][j+3]!=0)
							{
									k[j+3]=1;													
							}
							for(l=0;l<7;l++)
							{
							 if( k[l]==1 && choixIAdef==l && typedef !=1)
							 {
								 choixIAdef=7;
								 typedef=10;
								 System.out.println("DefReset");
							 }
							}
							
							
							  if(j>0 && tableaunbr[i][j-1]!=2  && i==5 && choixIAdef == 7) // 0 1 1 1 
							{
								choixIAdef=j-1;	
								typedef=1;
								System.out.println("Defense Horizontal -    i==5    0 1 1 1");
								
							}
							  for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAdef==l && typedef !=1)
								 {
									 choixIAdef=7;
									 typedef=10;
									 System.out.println("DefReset");
								 }
								}
								
							  
							  if(j>0 && i<5 &&tableaunbr[i][j-1]!=2 && tableaunbr[i+1][j-1]!=0   && choixIAdef == 7)
							{
									choixIAdef=j-1;	
									typedef=1;
									System.out.println("Defense Horizontal -  i!=5   0 1 1 1");
									
							}
							  if(j>0 && i==4 &&tableaunbr[i][j-1]!=2 && tableaunbr[i+1][j-1]==0  )
								{
										k[j-1]=1;											
								}
							  if(j>0 && i<4 &&tableaunbr[i][j-1]!=2 && tableaunbr[i+1][j-1]==0  && tableaunbr[i+2][j-1]!=0  )
								{
								  k[j-1]=1;										
								}
							  for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAdef==l && typedef !=1)
								 {
									 choixIAdef=7;
									 typedef=10;
									 System.out.println("DefReset");
								 }
								}
								
						}
						
						if(j<4 && tableaunbr[i][j+2]==0 && tableaunbr[i][j+3] == 1 && choixIAdef == 7 && i== 5) // 1 1 0 1
						{
							choixIAdef=j+2;	
							typedef=1;
							System.out.println("Defense Horizontal +  i==5   1 1 0 1 ");
							
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(j<4 && i!= 5 && tableaunbr[i][j+2]==0 && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+2] !=0 &&  choixIAdef == 7 ) 
						{
							choixIAdef=j+2;	
							typedef=1;
							System.out.println("Defense Horizontal +  i!=5   1 1 0 1");	
						}
						if(j<4 && i==4 && tableaunbr[i][j+2]==0 && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+2] ==0 ) 
						{
							k[j+2]=1;								
						}
						if(j<4 && i<4 && tableaunbr[i][j+2]==0 && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+2] ==0 && tableaunbr[i+2][j+2] !=0) 
						{
							k[j+2]=1;								
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
					}
					
					if(j<4 && tableaunbr[i][j+1]==0 && tableaunbr[i][j+2] == 1 && tableaunbr[i][j+3] == 1&& i== 5  && choixIAdef == 7 ) // 1 0 1 1
					{
						choixIAdef=j+1;	
						typedef=1;
						System.out.println("Defense Horizontal +  i==5   1 0 1 1 ");
						
					}
					for(l=0;l<7;l++)
					{
					 if( k[l]==1 && choixIAdef==l && typedef !=1)
					 {
						 choixIAdef=7;
						 typedef=10;
						 System.out.println("DefReset");
					 }
					}
					
					
					if(j<4 && i<5 &&  tableaunbr[i][j+1]==0 && tableaunbr[i][j+2] == 1  && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+1] !=0 &&  choixIAdef == 7) 
					{
						choixIAdef=j+1;	
						typedef=1;
						System.out.println("Defense Horizontal +  i!=5   1 0 1 1");
					}
					if(j<4 && i==4 &&  tableaunbr[i][j+1]==0 && tableaunbr[i][j+2] == 1  && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+1] ==0) 
					{
						k[j+1]=1;							
					}
					if(j<4 && i<4 &&  tableaunbr[i][j+1]==0 && tableaunbr[i][j+2] == 1  && tableaunbr[i][j+3] == 1 && tableaunbr[i+1][j+1] ==0  && tableaunbr[i+2][j+1] !=0) 
					{
						k[j+1]=1;							
					}
					for(l=0;l<7;l++)
					{
					 if( k[l]==1 && choixIAdef==l && typedef !=1)
					 {
						 choixIAdef=7;
						 typedef=10;
						 System.out.println("DefReset");
					 }
					}
					
				
				
				/*
				 * VERTICAL
				 */	
					if(i>0 && tableaunbr[i-1][j]==1)
					{
						if(i>1 && tableaunbr[i-2][j]==1)
						{
							if(i>2 && tableaunbr[i-3][j]!=2)
							{
								choixIAdef=j;
								typedef=1;
								System.out.println("Defense Vertical");
								
							}
						}
					}
					
					for(l=0;l<7;l++)
					{
					 if( k[l]==1 && choixIAdef==l && typedef !=1)
					 {
						 choixIAdef=7;
						 typedef=10;
						 System.out.println("DefReset");
					 }
					}

				
				
				
				/*
				 * OBLIQUE
				 */
						
						//Oblique -+
						if(i>2 && j<4 && tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i-2][j+3]!=0 && tableaunbr[i-3][j+3] == 0 && choixIAdef == 7)//1 1 1 0
						{		
								choixIAdef=j+3;
								typedef=1;
								System.out.println("Defense oblique -+          1 1 1 0");
								
						}
						if(i>2 && j<4 && tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i-2][j+3]==0 &&tableaunbr[i-1][j+3]!=0 && tableaunbr[i-3][j+3] == 0)
						{		
								k[j+3]=1;								
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>2 && j<4 && tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==0 && tableaunbr[i-1][j+2]!=0 && tableaunbr[i-3][j+3] == 1 && choixIAdef == 7)//1 1 0 1
						{		
								choixIAdef=j+2;
								typedef=1;
								System.out.println("Defense oblique -+       1 1 0 1");
								
						}
						if(i>2 && j<4 && tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==0 && tableaunbr[i-1][j+2]==0 && tableaunbr[i][j+2]!=0  && tableaunbr[i-3][j+3] == 1)//1 1 0 1
						{		
								k[j+2]=1;
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>2 && j<4 && tableaunbr[i-1][j+1]==0 && tableaunbr[i-2][j+2]==1 && tableaunbr[i][j+1]!=0 && tableaunbr[i-3][j+3] == 1 && choixIAdef == 7)//1 0 1 1 
						{		
								choixIAdef=j+1;
								typedef=1;
								System.out.println("Defense oblique -+       1 0 1 1");	
						}
						if(i>2 && i==5 && j<4 && tableaunbr[i-1][j+1]==0 && tableaunbr[i-2][j+2]==1 && tableaunbr[i][j+1]==0 && tableaunbr[i-3][j+3] == 1)
						{		
								k[j+1]=1;	
						}
						if(i>2&& i<5 && j<4 && tableaunbr[i-1][j+1]==0 && tableaunbr[i-2][j+2]==1 && tableaunbr[i][j+1]==0 && tableaunbr[i+1][j+1]!=0 && tableaunbr[i-3][j+3] == 1 )//1 0 1 1 
						{		
								k[j+1]=1;	
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>1 && i==4 && j<5 && j>0 &&tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i+1][j-1] == 0 && choixIAdef == 7)//0 1 1 1 
						{		
								choixIAdef=j-1;
								typedef=1;
								System.out.println("Defense oblique -+        0 1 1 1    i!=5");	
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>1 &&i<4 && j<5 && j>0 &&tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i+2][j-1] !=0 && choixIAdef == 7)//0 1 1 1 
						{		
								choixIAdef=j-1;
								typedef=1;
								System.out.println("Defense oblique -+        0 1 1 1   i==5");	
						}
						if(i>1 &&i==3 && j<5 && j>0 &&tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i+2][j-1] == 0 ) 
						{		
								k[j-1]=1;
						}
						if(i>1 &&i<3 && j<5 && j>0 &&tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1 && tableaunbr[i+2][j-1] == 0 && tableaunbr[i+3][j-1] !=0 ) 
						{		
								k[j-1]=1;
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						
						
						//Oblique --
						if(i>2 && j>2 && tableaunbr[i-1][j-1]==1&& tableaunbr[i-2][j-2]==1&& tableaunbr[i-2][j-3]!=0 && tableaunbr[i-3][j-3] == 0 && choixIAdef == 7) // 0 1 1 1
						{
								choixIAdef=j-3;
								typedef=1;
								System.out.println("Defense oblique --            0 1 1 1");
								
						}
						if(i>2 && j>2 && tableaunbr[i-1][j-1]==1&& tableaunbr[i-2][j-2]==1&& tableaunbr[i-2][j-3]==0 && tableaunbr[i-1][j-3]!=0 && tableaunbr[i-3][j-3] == 0 ) 
						{
								k[j-3]=1;		
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>2 && j>2 && tableaunbr[i-1][j-1]==1&& tableaunbr[i-2][j-2]==0 && tableaunbr[i-1][j-2]!=0 && tableaunbr[i-3][j-3] == 1 && choixIAdef == 7) // 1 0 1 1 
						{
								choixIAdef=j-2 ;
								typedef=1;
								System.out.println("Defense oblique --                 1 0 1 1");
								
						}
						if(i>2 && j>2 && tableaunbr[i-1][j-1]==1&& tableaunbr[i-2][j-2]==0 && tableaunbr[i-1][j-2]==0 && tableaunbr[i][j-2]!=0  && tableaunbr[i-3][j-3] == 1 ) 
						{
								k[j-2] =1;	
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>2 && j>2 && tableaunbr[i-1][j-1]==0 && tableaunbr[i-2][j-2]==1 && tableaunbr[i][j-1]!=0 && tableaunbr[i-3][j-3] == 1 && choixIAdef == 7) // 1 1 0 1 
						{
								choixIAdef=j-1 ;
								typedef=1;
								System.out.println("Defense oblique --                 1 1 0 1");		
						}
						if(i>2 && j>2 && i==5 && tableaunbr[i-1][j-1]==0 && tableaunbr[i-2][j-2]==1 && tableaunbr[i][j-1]==0 && tableaunbr[i-3][j-3] == 1 ) 
						{
								k[j-1]=1 ;
						}
						if(i>2 && j>2 && i<5 && tableaunbr[i-1][j-1]==0 && tableaunbr[i-2][j-2]==1 && tableaunbr[i][j-1]==0 && tableaunbr[i+1][j-1]!=0 && tableaunbr[i-3][j-3] == 1 ) 
						{
								k[j-1]=1 ;
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						if(i>1 && i<4 && j>1 &&j<6 && tableaunbr[i-1][j-1]==1 && tableaunbr[i-2][j-2]==1 && tableaunbr[i+2][j+1]!=0 && tableaunbr[i+1][j+1] == 0 && choixIAdef == 7) // 1 1 1 0 
						{
								choixIAdef=j+1 ;
								typedef=1;
								System.out.println("Defense oblique --                 1 1 1 0       i<4 ");	
						}
						if(i>1 && i==4 && j>1 &&j<6 && tableaunbr[i-1][j-1]==1 && tableaunbr[i-2][j-2]==1 && tableaunbr[i+1][j+1] == 0 && choixIAdef == 7)  
						{
								choixIAdef=j+1 ;
								typedef=1;
								System.out.println("Defense oblique --                 1 1 1 0  i == 4");	
						}
						if(i>1 && i==3 && j>1 &&j<6 && tableaunbr[i-1][j-1]==1 && tableaunbr[i-2][j-2]==1 && tableaunbr[i+2][j+1]==0 && tableaunbr[i+1][j+1] == 0 )  
						{
								k[j+1]=1 ;
						}
						if(i>1 && i<3 && j>1 &&j<6 && tableaunbr[i-1][j-1]==1 && tableaunbr[i-2][j-2]==1 && tableaunbr[i+2][j+1]==0  && tableaunbr[i+3][j+1]!=0 && tableaunbr[i+1][j+1] == 0 )  
						{
								k[j+1]=1 ;
						}
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAdef==l && typedef !=1)
						 {
							 choixIAdef=7;
							 typedef=10;
							 System.out.println("DefReset");
						 }
						}
						
						
						
						
					/*
					 * PREVISION DEFENSE  Niveau 2
					 */
					
					
					
				/*
				 * HORIZONTAL PREVISION  1 0 1
				 */
				
					if(j<4 && tableaunbr[i][j+2] == 1)
					{
						if(tableaunbr[i][j+1] == 0 && tableaunbr[i][j+3] != 2 && i== 5 && choixIAdef == 7)
						{	
									choixIAdef=j+1;
									typedef=2;
									System.out.println("Defense Horizontal prevision 1 0 1 0    i==5");
									
								
								
						}
						if(tableaunbr[i][j+1] == 0 && tableaunbr[i][j+3] != 2  && i!= 5  && tableaunbr[i+1][j+1] != 0 && choixIAdef == 7)
						{	
									choixIAdef=j+1;
									typedef=2;
									System.out.println("Defense Horizontal prevision  1 0 1 0   i!=5");
									
								
								
						}
					}
					if(j>1&& j<4 && tableaunbr[i][(j+2)] == 1)
					{
						if(tableaunbr[i][j+1] == 0 && tableaunbr[i][j-1] != 2 && i== 5 && choixIAdef == 7)
						{	
									choixIAdef=j+1;
									typedef=2;
									System.out.println("Defense Horizontal prevision 0 1 0 1 i==5");
									
								
								
						}
						if(tableaunbr[i][j+1] == 0 && tableaunbr[i][j-1] == 0  && i!= 5 && tableaunbr[i+1][j+1] == 0 && choixIAdef == 7)
						{	
									choixIAdef=j+1;
									typedef=2;
									System.out.println("Defense Horizontal prevision 0 1 0 1  i!=5");
									
								
								
						}
					}
					for(l=0;l<7;l++)
					{
					 if( k[l]==1 && choixIAdef==l && typedef !=1)
					 {
						 choixIAdef=7;
						 typedef=10;
						 System.out.println("DefReset");
					 }
					}
				
				
				
				/*
				 * HORIZONTAL PREVISION 0 1 1 0
				 */
				
					if(j<6 && tableaunbr[i][j+1]==1)
					{
						if(i == 5 && j>0 &&j<5 && tableaunbr[i][j+2]==0 && tableaunbr[i][j-1]==0 && choixIAdef == 7)
						{
							
								choixIAdef=j-1;
								typedef=3;
								System.out.println("Defense Horizontal prevision 0 1 1 0   i==5");
								
							
						}

						if(i != 5 && j>0 &&j<5 && tableaunbr[i][j+2]==0 && tableaunbr[i+1][j+2]!=0 && tableaunbr[i][j-1]== 0 && tableaunbr[i+1][j-1]!=0 && choixIAdef == 7)
						{
							
								choixIAdef=j-1;
								typedef=3;
								System.out.println("Defense Horizontal prevision 0 1 1 0   i!=5");
								
							
						}	
					}
				
					for(l=0;l<7;l++)
					{
					 if( k[l]==1 && choixIAdef==l && typedef !=1)
					 {
						 choixIAdef=7;
						 typedef=10;
						 System.out.println("DefReset");
					 }
					}
				
				}
			}		
		}
		
		

		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//ATTAQUE
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		

		for(i=0;i<6;i++)
		{
			for(j=0;j<7;j++) 
			{	
				if(tableaunbr[i][j]==2 )   //ELLE TROUVE UN DE SES PIONS
				{
				
					
					//Niveau 1
					
					//ATTAQUE HORIZONTAL 
					
					if(j<6 && tableaunbr[i][j+1] == 2 )
					{
						if(j<5 && tableaunbr[i][j+2] == 2)
						{
							if(j<4 && i==5 && tableaunbr[i][j+3] == 0 && choixIAatt==7) //   2 2 2 0
							{
							choixIAatt = j+3;
							System.out.println("Attaque Horizontal +  i==5");
							typeatt = 1;
							}
							if(j>0 && i==5 && tableaunbr[i][j-1] == 0 && choixIAatt==7) //    0 2 2 2
							{
							choixIAatt = j-1;
							System.out.println("Attaque Horizontal -   i==5");
							typeatt = 1;
							}
						}
						if(j<4 && i==5 && tableaunbr[i][j+3] == 2 && tableaunbr[i][j+2] == 0 && choixIAatt==7 ) // 2 2 0 2
						{
							choixIAatt = j+2;
							System.out.println("Attaque Horizontal 2 2 0 2  i==5");
							typeatt = 1;
						}
						if(j>1 && i==5 && tableaunbr[i][j-2] == 2 && tableaunbr[i][j-1] == 0 && choixIAatt==7) //  2 0 2 2 
						{
							choixIAatt = j-1;
							System.out.println("Attaque Horizontal 2 0 2 2  i==5");
							typeatt = 1;
						}
						
						
					//i!=5
						
						if(j<4 && i!=5 && tableaunbr[i][j+3] == 0 && tableaunbr[i+1][j+3] !=0 && tableaunbr[i][j+2] == 2 && choixIAatt==7) //   2 2 2 0
						{
						choixIAatt = j+3;
						System.out.println("Attaque Horizontal +   i!=5");
						typeatt = 1;
						}
						if(j>0 && j<5 && i!=5 && tableaunbr[i][j-1] == 0 && tableaunbr[i+1][j-1] != 0 && tableaunbr[i][j+2] == 2 && choixIAatt==7 ) //    0 2 2 2
						{
						choixIAatt = j-1;
						System.out.println("Attaque Horizontal -   i!=5");
						typeatt = 1;
						}
					}
					if(j<4 && i!=5 && tableaunbr[i][j+3] == 2 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j+2] == 0 && tableaunbr[i+1][j+2] != 0 && choixIAatt==7 ) // 2 2 0 2
					{
						choixIAatt = j+2;
						System.out.println("Attaque Horizontal 2 2 0 2  i!=5");
						typeatt = 1;
					}
					if(j>1 && j<6 && i!=5 && tableaunbr[i][j-2] == 2 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j-1] == 0 && tableaunbr[i+1][j-1] !=0 && choixIAatt==7) //  2 0 2 2 
					{
						choixIAatt = j-1;
						System.out.println("Attaque Horizontal 2 0 2 2  i!=5");
						typeatt = 1;
					}
					
					
					
					
					//ATTAQUE VERTICAL
						if(i>2 && tableaunbr[i-1][j] == 2 && tableaunbr[i-2][j] == 2 && tableaunbr[i-3][j] == 0 && choixIAatt==7)
						{
							choixIAatt = j ;
							System.out.println("Attaque Vertical");
							typeatt = 1;
						}
					
					
					
					
					
					
					//ATTAQUE OBLIQUE  -+ 
					if(j<6 && i>0 && tableaunbr[i-1][j+1] == 2 && choixIAatt==7)
					{
						if(j<4 && i>2 && tableaunbr[i-2][j+2] == 2 && tableaunbr[i-3][j+3] == 0 && tableaunbr[i-2][j+3] != 0 && choixIAatt==7 ) // 2 2 2 0
						{
							choixIAatt = j+3 ;
							System.out.println("Attaque oblique -+   2 2 2 0");
							typeatt = 1;
						}
						
						if(j<4 && i>2 && tableaunbr[i-3][j+3] == 2 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-1][j+2] !=0 && choixIAatt==7) // 2 2 0 2
						{
							choixIAatt = j+2 ;
							System.out.println("Attaque oblique -+  2 2 0 2 ");
							typeatt = 1;
						}
					}
					if(j<6 && i>0 && tableaunbr[i-1][j+1] == 0 && choixIAatt==7)
					{
						if(j<4 && i>2 && tableaunbr[i-2][j+2] == 2 && tableaunbr[i-3][j+3] == 2 && tableaunbr[i][j+1] != 0 && choixIAatt==7) // 2 0 2 2
						{
							choixIAatt = j+1 ;
							System.out.println("Attaque oblique -+   2 0 2 2");
							typeatt = 1;
						}
					}
					if(j<6 && i>0 && tableaunbr[i-1][j+1] == 2 && choixIAatt==7)
					{
						if(j<5 && j>0 && i>1 && i<5 && tableaunbr[i-2][j+2] == 2 && tableaunbr[i+1][j-1] == 0 && choixIAatt==7 ) // 0 2 2 2
						{
							choixIAatt = j-1 ;
							System.out.println("Attaque oblique -+   0 2 2 2");
							typeatt = 1;
						}
					}
					
					//ATTAQUE OBLIQUE  --

					if(j>0 && i>0 && tableaunbr[i-1][j-1] == 2)
					{
						if(j>2 && i>2 && tableaunbr[i-2][j-2] == 2 && tableaunbr[i-3][j-3] == 0 && tableaunbr[i-2][j-3] != 0 && choixIAatt==7)  // 0 2 2 2 
						{
							choixIAatt = j-3 ;
							System.out.println("Attaque oblique --  0 2 2 2 ");
							typeatt = 1;
						}
						
						if(j>2 && i>2 && tableaunbr[i-3][j-3] == 2 && tableaunbr[i-2][j-2] == 0 && tableaunbr[i-1][j-2] != 0 && choixIAatt==7)  // 2 0 2 2 
						{
							choixIAatt = j-2 ;
							System.out.println("Attaque oblique --   2 0 2 2 ");
							typeatt = 1;
						}
					}
					if(j>0 && i>0 && tableaunbr[i-1][j-1] == 0)
					{
						if(j>2 && i>2 && tableaunbr[i-2][j-2] == 2 && tableaunbr[i-3][j-3] == 2 && tableaunbr[i][j-1] != 0 && choixIAatt==7)  // 2 2 0 2 
						{
							choixIAatt = j-1 ;
							System.out.println("Attaque oblique --  2 2 0 2 ");
							typeatt = 1;
						}
					}
					if(j<6 && i<5 && tableaunbr[i+1][j+1] == 0)
					{
						if(j>1 && i==4 && tableaunbr[i-1][j-1] == 2 && tableaunbr[i-2][j-2] == 2 && choixIAatt==7 ) // 2 2 2 0
						{
							choixIAatt = j+1 ;
							System.out.println("Attaque oblique --   2 2 2 0");
							typeatt = 1;
						}
						if(j>1 && i>1 && i<4 && tableaunbr[i-1][j-1] == 2 && tableaunbr[i-2][j-2] == 2 && tableaunbr[i+2][j+1] !=0 && choixIAatt==7 )
						{
							choixIAatt = j+1 ;
							System.out.println("Attaque oblique --   2 2 2 0    i!=5");
							typeatt = 1;
						}
					}
					
				}
			}
		}
		
		

		for(i=0;i<6;i++)
		{
			for(j=0;j<7;j++) 
			{	
				if(tableaunbr[i][j]==2 )   //ELLE TROUVE UN DE SES PIONS
				{
					//AIDE HORIZONTAL 3 PIONS
					
					if(j<6 && tableaunbr[i][j+1] == 2 )
					{
					
					if(j<4 && i!=5 && tableaunbr[i][j+3] == 0 && tableaunbr[i+1][j+3] ==0 && tableaunbr[i][j+2] == 2 && choixIAatt==7) //   2 2 2 0
					{
					choixIAatt = j+3;
					System.out.println("Aide Attaque Horizontal +   i!=5");
					typeatt = 2;
					}
					if(j>0 && j<5 && i!=5 && tableaunbr[i][j-1] == 0 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i][j+2] == 2 && choixIAatt==7 ) //    0 2 2 2
					{
					choixIAatt = j-1;
					System.out.println("Aide Attaque Horizontal -   i!=5");
					typeatt = 2;
					}
				}
				if(j<4 && i!=5 && tableaunbr[i][j+3] == 2 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j+2] == 0 && tableaunbr[i+1][j+2] == 0 && choixIAatt==7 ) // 2 2 0 2
				{
					choixIAatt = j+2;
					System.out.println("Aide Attaque Horizontal 2 2 0 2  i!=5");
					typeatt = 2;
				}
				if(j>1 && j<6 && i!=5 && tableaunbr[i][j-2] == 2 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j-1] == 0 && tableaunbr[i+1][j-1] ==0 && choixIAatt==7) //  2 0 2 2 
				{
					choixIAatt = j-1;
					System.out.println("Aide Attaque Horizontal 2 0 2 2  i!=5");
					typeatt = 2;
				}
					
					
				}
				
				
				
				
				
			}
		}
					
					for(i=0;i<6;i++)
					{
						for(j=0;j<7;j++) 
						{	
							if(tableaunbr[i][j]==2 )   //ELLE TROUVE UN DE SES PIONS
							{
								 
								//PREVISION D'ATTAQUE   Niveau 2
								
								//PREVISION HORIZONTAL
								if(j<4 && i==5 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 0 && choixIAatt==7) // 2 2 0 0 
								{
									choixIAatt=j+2;
									System.out.println("Attaque Prévision Horizontal +    i==5     2 2 0 0");
									typeatt = 3;
								} 
								if(j<6 && j>1 && i==5 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j-1] == 0 && tableaunbr[i][j-2] == 0 && choixIAatt==7)// 0 0 2 2
								{
									choixIAatt=j-1;
									System.out.println("Attaque Prévision Horizontal -     i==5    0 0 2 2");
									typeatt = 3;
								}
								if(j<5 && j>0 && i==5 && tableaunbr[i][j-1] == 0 && tableaunbr[i][j+1] == 0 &&  tableaunbr[i][j+2] == 2 && choixIAatt==7)// 0 2 0 2
								{
									choixIAatt=j+1;
									System.out.println("Attaque Prévision Horizontal -     i==5    0 2 0 2");
									typeatt = 3;
								}
								if(j<4 && i!=5 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 0 && tableaunbr[i+1][j+2] != 0 && tableaunbr[i+1][j+3] != 0 && choixIAatt==7)// 2 2 0 0
								{
									choixIAatt=j+2;
									System.out.println("Attaque Prévision Horizontal +    i!=5   2 2 0 0");
									typeatt = 3;
								}
								if(j<6 && j>1 && i!=5 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j-1] == 0 && tableaunbr[i][j-2] == 0 && tableaunbr[i+1][j-1] !=0 && tableaunbr[i+1][j-2] != 0 && choixIAatt==7)// 0 0 2 2
								{
									choixIAatt=j-1;
									System.out.println("Attaque Prévision Horizontal -     i!=5    0 0 2 2");
									typeatt = 3;
								}
								if(j<5 && j>0 && i!=5 && tableaunbr[i][j-1] == 0 && tableaunbr[i][j+1] == 0 &&  tableaunbr[i][j+2] == 2 && tableaunbr[i+1][j-1] !=0 && tableaunbr[i+1][j+1] != 0 && choixIAatt==7)// 0 2 0 2
								{
									choixIAatt=j+1;
									System.out.println("Attaque Prévision Horizontal -     i!=5    0 2 0 2");
									typeatt = 3;
								}
								
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l && typeatt !=1)
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
								
								//PREVISION VERTICAL
								if(i>2 && tableaunbr[i-1][j] == 2 && tableaunbr[i-2][j] == 0 && tableaunbr[i-3][j] == 0 && choixIAatt==7)
								{
									choixIAatt=j;
									System.out.println("Attaque Prévision vertical ");
									typeatt = 3;
								}
							
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l && typeatt !=1)
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
								//PREVISION OBLIQUE
								//OBLIQUE +
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 2 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-3][j+3] == 0) // 2 2 0 0
								{
									if(i>0 && j<5 && tableaunbr[i-1][j+2]!=0 && choixIAatt==7) {
									choixIAatt=j+2;
									System.out.println("Attaque Prévision oblique -+    2 2 0 0");
									typeatt = 4;
									}
								}
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 0 && tableaunbr[i-2][j+2] == 2 && tableaunbr[i-3][j+3] == 0 ) // 2 0 2 0
								{
									if(j<5 && tableaunbr[i][j+1]!=0 && choixIAatt==7) {
									choixIAatt=j+1;
									System.out.println("Attaque Prévision oblique -+    2 0 2 0");
									typeatt = 4;
									}
								}
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 0 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-3][j+3] == 2) // 2 0 0 2
								{
									if(j<5 && tableaunbr[i][j+1]!=0 && choixIAatt==7) {
									choixIAatt=j+1;
									System.out.println("Attaque Prévision oblique -+    2 0 0 2");
									typeatt = 4;
									}
								}
								if(i>1 && i<5 &&j<4 && j>0 &&tableaunbr[i-1][j+1] == 2 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i-2][j+2] == 0) // 0 2 2 0
								{
									if(j<5 && tableaunbr[i][j-1]!=0 && choixIAatt==7) {
									choixIAatt=j-1;
									System.out.println("Attaque Prévision oblique -+    0 2 2 0");
									typeatt = 4;
									}
								}
								if(i>1 && i<4 &&j<5 &&j>1 && tableaunbr[i][j] == 2 && tableaunbr[i-1][j+1] == 2 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i+2][j-2] == 0 && choixIAatt==7) // 0 0 2 2
								{
									if(i<4 && j>0 && tableaunbr[i+2][j-1]!=0) {
									choixIAatt=j-1;
									System.out.println("Attaque Prévision oblique -+    0 0 2 2");
									typeatt = 4;
									}
								}
								if(i>1 && i<4 && j>0 &&j<5 && tableaunbr[i-1][j+1] == 0 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i-2][j+2] == 2 && choixIAatt==7) // 0 2 0 2
								{			
									if(j<6 && tableaunbr[i][j+1]!=0) {
									choixIAatt=j+1;
									System.out.println("Attaque Prévision oblique -+    0 2 0 2");
									typeatt = 4;
									}
								}
								
								
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l && typeatt !=1)
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
								//OBLIQUE -
								if(i<3 &&j<4 && tableaunbr[i+1][j+1] == 2 && tableaunbr[i+2][j+2] == 0 && tableaunbr[i+3][j+3] == 0 && choixIAatt==7) // 2 2 0 0
								{
									if(i<3 && j<5 && tableaunbr[i+3][j+2]!=0) {
									choixIAatt=j+2;
									System.out.println("Attaque Prévision oblique --  2 2 0 0");
									typeatt = 4;
									}
								}
								if(i<4 && j<5 && i>1 && j>1 &&  tableaunbr[i-1][j-1] == 0 && tableaunbr[i-2][j-2] == 2 && tableaunbr[i+1][j+1] == 0 && choixIAatt==7) // 2 0 2 0
								{
									if(j>0 && tableaunbr[i][j-1]!=0) {
									choixIAatt=j-1;
									System.out.println("Attaque Prévision oblique --    2 0 2 0");
									typeatt = 4;
									}
								}
								if(i>2 &&j>2 && tableaunbr[i-1][j-1] == 0 && tableaunbr[i-2][j-2] == 0 && tableaunbr[i-3][j-3] == 2 && choixIAatt==7) // 2 0 0 2
								{
									if(j>5 && tableaunbr[i][j-1]!=0) {
									choixIAatt=j-1;
									System.out.println("Attaque Prévision oblique --    2 0 0 2");
									typeatt = 4;
									}
								}
								if(i<5 && i>1 && j<6 && j>1 && tableaunbr[i-1][j-1] == 2 && tableaunbr[i+1][j+1] == 0 && tableaunbr[i-2][j-2] == 0 && choixIAatt==7) // 0 2 2 0
								{
									if(i>0 && j>1 && tableaunbr[i-1][j-2]!=0) {
									choixIAatt=j-2;
									System.out.println("Attaque Prévision oblique --    0 2 2 0");
									typeatt = 4;
									}
									if(i<5 && j<5 && tableaunbr[i+1][j+2]!=0) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision oblique --    0 2 2 0");
										typeatt = 4;
										}
								}
								if(i>2 && j>2 && tableaunbr[i-1][j-1] == 2 && tableaunbr[i-2][j-2] == 0 && tableaunbr[i-3][j-3] == 0 && choixIAatt==7) // 0 0 2 2
								{
									if(i>0 && j>1 && tableaunbr[i-1][j-2]!=0) {
									choixIAatt=j-2;
									System.out.println("Attaque Prévision oblique --    0 0 2 2");
									typeatt = 4;
									}
								}
								if(i>2 && j>2 && tableaunbr[i-1][j-1] == 0 && tableaunbr[i-2][j-2] == 2 && tableaunbr[i-3][j-3] == 0 && choixIAatt==7) // 0 2 0 2
								{
									if(j>0 && tableaunbr[i][j-1]!=0) {
									choixIAatt=j-1;
									System.out.println("Attaque Prévision oblique --    0 2 0 2");
									typeatt = 4;
									}
								}
								
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l  && typeatt !=1 )
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
							}
						}	
						
					}
				
				
				
					for(i=0;i<6;i++) {
						for(j=0;j<7;j++) {
							if(tableaunbr[i][j]==2)
							{
								
								//AIDE HORIZONTAL
								if(j<4 && tableaunbr[i][j+1] == 2 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 0  && choixIAatt==7 ) // 2 2 00 0
								{
									
									if(i==5 &&choixIAatt==7) {
										choixIAatt=j+2;
										System.out.println("Attaque Prévision Horizontal    2 2 00 0");
										typeatt = 6;
										}
									
									if(i<5 &&tableaunbr[i+1][j+2]!=0 &&choixIAatt==7) {
										choixIAatt=j+2;
										System.out.println("Attaque Prévision Horizontal   2 2 00 0");
										typeatt = 6;
										}
								
								}
								if(j<4 && tableaunbr[i][j+1] == 0 && tableaunbr[i][j+2] == 2 && tableaunbr[i][j+3] == 0  && choixIAatt==7 ) // 2 00 2 0
								{
									
									if(i==5 &&choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision Horizontal    2 00 2 0   i==5");
										typeatt = 6;
										}
									
									if(i<5 &&tableaunbr[i+1][j+1]!=0 &&choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision Horizontal   2 00 2 0");
										typeatt = 6;
										}
								
								}
								if(j<4 && tableaunbr[i][j+1] == 0 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 2  && choixIAatt==7 ) // 2 00 0 2
								{
									
									if(i==5 &&choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision Horizontal    2 00 0 2   i==5");
										typeatt = 6;
										}
									
									if(i<5 &&tableaunbr[i+1][j+1]!=0 &&choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision Horizontal   2 00 0 2");
										typeatt = 6;
										}
								
								}
								
								
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l && typeatt !=1)
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
								
								//AIDE A LA PREVISION OBLIQUE +
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 2 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-3][j+3] == 0  && choixIAatt==7 ) // 2 2 00 0
								{
									
									if(i>0 && j<5 && tableaunbr[i-1][j+2]==0 &&tableaunbr[i][j+2]!=0 &&choixIAatt==7) {
										choixIAatt=j+2;
										System.out.println("Attaque Prévision oblique -+    2 2 00 0");
										typeatt = 6;
										}
								
								}
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 0 && tableaunbr[i-2][j+2] == 2 && tableaunbr[i-3][j+3] == 0 && choixIAatt==7 ) // 2 00 2 0
								{
									if(j<6 && i==5 &&tableaunbr[i][j+1]==0 &&choixIAatt == 7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision oblique -+    2 00 2 0     i==5");
										typeatt = 6;
										}
									if(j<6 && i<5 && tableaunbr[i][j+1]==0 && tableaunbr[i+1][j+1]!=0 &&choixIAatt == 7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision oblique -+    2 00 2 0");
										typeatt = 6;
										}
								}
								if(i>2 &&j<4 && tableaunbr[i-1][j+1] == 0 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-3][j+3] == 2  && choixIAatt==7 ) // 2 00 0 2
								{
									if(j<5 && i==5 &&tableaunbr[i][j+1]==0  && choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision oblique -+    2 00 0 2   i==5"  );
										typeatt = 6;
										}
									if(j<5 && i<5 &&tableaunbr[i][j+1]==0&& tableaunbr[i+1][j+1]!=0  && choixIAatt==7) {
										choixIAatt=j+1;
										System.out.println("Attaque Prévision oblique -+    2 00 0 2");
										typeatt = 6;
										}
								}
								if(i>1 && i<5 &&j<4 && j>0 &&tableaunbr[i-1][j+1] == 2 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i-2][j+2] == 0) // 00 2 2 0
								{
									if(j<5 && i==4 && choixIAatt==7) {
										choixIAatt=j-1;
										System.out.println("Attaque Prévision oblique -+    00 2 2 0   i == 4");
										typeatt = 6;
										}
									if(j<5 && i<4 && tableaunbr[i+2][j-1] != 0 && choixIAatt==7) {
										choixIAatt=j-1;
										System.out.println("Attaque Prévision oblique -+    00 2 2 0");
										typeatt = 6;
										}
								}
								
								
								for(l=0;l<7;l++)
								{
								 if( k[l]==1 && choixIAatt==l && typeatt !=1)
								 {
									 choixIAatt=7;
									 typeatt=10;
									 System.out.println("AttReset");
								 }
								}
								
				}	
				
			}
		}
		
		
		if(choixIAatt==7) {
			for(i=0;i<6;i++) {
				for(j=0;j<7;j++) {
					if(tableaunbr[i][j]==2) // 1 Pion
					{
						
						//1 PION 
						
						//HORIZONTAL	
						if(j<4 && i==5 && tableaunbr[i][j+1] == 0 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 0 && choixIAatt == 7) // 2 0 0 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion    2 0 0 0");
							typeatt = 9;
						}
						if(j<3 && i<5 && tableaunbr[i][j+1] == 0 && tableaunbr[i+1][j+1] != 0 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j+3] == 0 && choixIAatt == 7)
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion   i!=5   2 0 0 0");
							typeatt = 9;
						}
						if(j<5&&j>0 && i==5 && tableaunbr[i][j+1] == 0 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)// 0 2 0 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion    0 2 0 0 ");
							typeatt = 9;
						}
						if(j<4&& j>0 && i<5 && tableaunbr[i][j+1] == 0 && tableaunbr[i+1][j+1] != 0 && tableaunbr[i][j+2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion   i!=5   0 2 0 0 ");
							typeatt = 9;
						}
						if(j<6 && j>1 && i==5 && tableaunbr[i][j+1] == 0 && tableaunbr[i][j-2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)// 0 0 2 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion    0 0 2 0 ");
							typeatt = 9;
						}
						if(j<5 && j>1 && i<5 && tableaunbr[i][j+1] == 0 && tableaunbr[i+1][j+1] != 0 && tableaunbr[i][j-2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)
						{
							choixIAatt=j+1;
							System.out.println("Attaque Horizontal 1 pion   i!=5   0 0 2 0 ");
							typeatt = 9;
						}
						if(j>2 && i==5 && tableaunbr[i][j-3] == 0 && tableaunbr[i][j-2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)// 0 0 0 2
						{
							choixIAatt=j-1;
							System.out.println("Attaque Horizontal 1 pion    0 0 0 2 ");
							typeatt = 9;
						}
						if(j>2 && i<5 && tableaunbr[i][j-3] == 0 && tableaunbr[i+1][j-1] != 0 && tableaunbr[i][j-2] == 0 && tableaunbr[i][j-1] == 0 && choixIAatt == 7)
						{
							choixIAatt=j-1;
							System.out.println("Attaque Horizontal 1 pion   i!=5   0 0 0 2 ");
							typeatt = 9;
						}
						
						
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAatt==l && typeatt !=1)
						 {
							 choixIAatt=7;
							 typeatt=10;
							 System.out.println("AttReset");
						 }
						}
						
						//OBLIQUE
						//oblique +
						
						if(j<4 && i>2 && tableaunbr[i-1][j+1] == 0 &&tableaunbr[i][j+1] !=0 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i-3][j+3] == 0 && choixIAatt == 7) // 2 0 0 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Oblique + 1 pion    2 0 0 0");
							typeatt = 9;
						}
						if(j<5&&j>0 && i<5&& i>1 &&tableaunbr[i-1][j+1] == 0 && tableaunbr[i][j+1] !=0 && tableaunbr[i-2][j+2] == 0 && tableaunbr[i+1][j-1] == 0 && choixIAatt == 7)// 0 2 0 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Oblique + 1 pion    0 2 0 0 ");
							typeatt = 9;
						}
						if(j<6 && j>1 && i<4 && i>0 &&tableaunbr[i-1][j+1] == 0 && tableaunbr[i][j+1] !=0 && tableaunbr[i+2][j-2] == 0 && tableaunbr[i+1][j-1] == 0 && choixIAatt == 7)// 0 0 2 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Oblique + 1 pion    0 0 2 0 ");
							typeatt = 9;
						}
						if(j>2 && i<3 &&tableaunbr[i+3][j-3] == 0 && tableaunbr[i+2][j-2] == 0 && tableaunbr[i+1][j-1] == 0 && tableaunbr[i+2][j-1] !=0 && choixIAatt == 7)// 0 0 0 2
						{
							choixIAatt=j-1;
							System.out.println("Attaque Oblique + 1 pion    0 0 0 2 ");
							typeatt = 9;
						}
						
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAatt==l && typeatt !=1)
						 {
							 choixIAatt=7;
							 typeatt=10;
							 System.out.println("AttReset");
						 }
						}
						
						//oblique -
						if( j>2 && i>2 && tableaunbr[i-1][j-1] == 0 &&tableaunbr[i][j-1] !=0 && tableaunbr[i-2][j-2] == 0 && tableaunbr[i-3][j-3] == 0 && choixIAatt == 7) //  0 0 0 2
						{
							choixIAatt=j-1;
							System.out.println("Attaque Oblique - 1 pion     0 0 0 2");
							typeatt = 9;
						}
						if(j>1 && j<6 && i>1 && i<5 && tableaunbr[i-1][j-1] == 0 && tableaunbr[i][j-1] !=0 && tableaunbr[i-2][j-2] == 0 && tableaunbr[i+1][j+1] == 0 && choixIAatt == 7)// 0 0 2 0
						{
							choixIAatt=j-1;
							System.out.println("Attaque Oblique - 1 pion   0 0 2 0 ");
							typeatt = 9;
						}
						if(j>0 && j<5 && i>0 &&i<4 &&tableaunbr[i-1][j-1] == 0 && tableaunbr[i][j-1] !=0 && tableaunbr[i+2][j+2] == 0 && tableaunbr[i+1][j+1] == 0 && choixIAatt == 7)// 0 2 0 0
						{
							choixIAatt=j-1;
							System.out.println("Attaque Oblique - 1 pion    0 2 0 0 ");
							typeatt = 9;
						}
						if(j<4 && i<3 && tableaunbr[i+3][j+3] == 0 && tableaunbr[i+2][j+2] == 0 && tableaunbr[i+1][j+1] == 0 && tableaunbr[i+2][j+1] !=0 && choixIAatt == 7)// 2 0 0 0
						{
							choixIAatt=j+1;
							System.out.println("Attaque Oblique - 1 pion    2 0 0 0  ");
							typeatt = 9;
						}
						
						for(l=0;l<7;l++)
						{
						 if( k[l]==1 && choixIAatt==l && typeatt !=1)
						 {
							 choixIAatt=7;
							 typeatt=10;
							 System.out.println("AttReset");
						 }
						}
						
						//VERTICAL
						/*   GAMEPLAY PAS OUF
						 if(i>2 && tableaunbr[i-1][j] == 0 && tableaunbr[i-2][j] == 0 && tableaunbr[i-3][j] == 0 && choixIAatt == 7)
						{
							choixIAatt=j;
							System.out.println("Attaque Horizontal 1 pion    vertical");
							typeatt = 9;
						}
						*/
						
						
					}
				}
			}}
					
					if(tableaunbr[5][3]==0 &&choixIAatt==7) {
						choixIAatt=3;
						typeatt=9;
					}
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.println("Coup n° "+compt);

					
		
			//Affichage du tableau K
			for(i=0;i<7;i++)
			 {
				 System.out.print(k[i]+" ");
			 }
			 
			 System.out.println();			
					
					
					
		
		
		//CHOIX ENTRE ATTAQUER ET DEFENDRE
		
		
		if(typedef<typeatt)
		{
			choixIAfinal = choixIAdef ;
		}
		else if(typeatt<typedef)
		{
			choixIAfinal = choixIAatt ;
		}
		else if(typeatt==typedef)
		{
			choixIAfinal = choixIAatt;  //La meilleur défense ,c'est l'attaque 
		}
		
		
		
		
		
		//PRISE EN COMPTE DE LA DIFFICULTE
		
		switch(diff)
		{
		case 1://difficulté facile   =>    1 tour sur 3 = aléatoire
			
			if(compt%3==1)
			{
				choixIAfinal=(int)(Math.random()*7);
				System.out.println("choix aléatoire");
			}
			break;
			
		case 2 ://difficulté moyenne     =>  1 tour sur 6 = aléatoire
			
			if(compt%6==1)
			{
				choixIAfinal=(int)(Math.random()*7);
				System.out.println("choix aléatoire");
			}
			break;
			
		case 3://difficutlé hard         => 0 aléatoire
			
			break;
		}
		
		for(j=0;j<7;j++)
		 {
		  		if(k[j]==1)
		  		{
		  			compteur++;
		  		}
		 }
		
		//System.out.println(" compteur = " + compteur);

		 if(choixIAfinal==7) //Si l'IA ne sait pas quoi faire 
		{
			 choixIAfinal=(int)(Math.random()*7);
			 
			 if(compteur !=7 ) 
			 {
				 do
				  {
				 
						choixIAfinal=(int)(Math.random()*7);
						System.out.println("Random 0");
				  
				  }while(k[choixIAfinal]==1);
			 }	 
		}
		 if(compteur ==7 && compt<42) {
			 
			 for(j=0;j<6;j++) {
				 if(tableaunbr[0][j]==0)
				 {
					 choixIAfinal=j;
				 }
			 }
		 }
		
		 
			 
		 
		System.out.println("typeAtt:"+typeatt+"  Att:"+choixIAatt+"  typedef:"+typedef+"  Def:"+choixIAdef+"  Choix:  " + choixIAfinal);
		
		if(compt<42) {
		switch(choixIAfinal){	
		
		case 0:
			col1.doClick();
			break;		
		case 1:
			col2.doClick();
			break;
		case 2:
			col3.doClick();
			break;
		case 3:
			col4.doClick();
			break;
		case 4:
			col5.doClick();
			break;
		case 5:
			col6.doClick();
			break;
		case 6:
			col7.doClick();
			break;
		}
		}
	}
}
