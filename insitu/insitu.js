
		//build a new array containing number values
		var r=0;
	        var p=9;
	        var q=4;	
		var exchCalls=0;
		var a = [4, 2, 10, 6,4,5,3,5,6,2,43,5, 9];
				document.write("Initial array </br>");
				document.write("---------------------");
				document.write("</br>");
				document.write(a);
				document.write("</br>");
				document.write("P="+p+"&nbsp");
				document.write("q="+q+"&nbsp");
				document.write("r="+r+"&nbsp");
				document.write("</br>");


		while(p!=q){
		
			if(p>q){
				document.write("P="+p+"&nbsp");
				document.write("q="+q+"&nbsp");
				document.write("r="+r+"&nbsp");
				document.write("</br>");
				document.write("P is > than Q </br>");
				exch(a,r+p-q,r+p,q);
				p=p-q; 
			}
			else{
				document.write("P="+p+"&nbsp");
				document.write("q="+q+"&nbsp");
				document.write("r="+r+"&nbsp");
				document.write("</br>");
				document.write("P is < than Q </br>");
				exch(a,r,r+p,q);
				r=r+p;
				q=q-p;

			}

		}
				document.write("P is = than Q </br>");
				document.write("P="+p+"&nbsp");
				document.write("q="+q+"&nbsp");
				document.write("r="+r+"&nbsp");
				document.write("</br>");
		exch(a,r,r+p,q);



		
		//build your custom function: this is a simple formula
		
		function exch(a,p,q,r )
		
		{
			var i=0;
				exchCalls++;
				matchRed=0;
				matchBlue=0;
				document.write("the "+exchCalls+" Swap" );
				document.write("</br>");
			while(i!=r){
				swap(a,p+i,q+i);
				for (j=0;j<a.length;j++) { 
					if(j==p+i){
					document.write("<FONT color='red'>"+a[j] + ",</font>"); 
					matchRed=p+i;
					continue;
					}
					if(j==q+i){
					document.write("<FONT color='blue'>"+a[j] + ",</font>"); 
					matchRed=p+i;
					continue;
					}
					if(j>=p&&j<p+i){
					document.write("<FONT color='red'>"+a[j] + ",</font>"); 
					continue;
					}
					if(j>=q&&j<q+i){
					document.write("<FONT color='blue'>"+a[j] + ",</font>"); 
					continue; 
					}
					document.write(a[j]+","); 

					}
				document.write("</br>");
				i++;

			
			}
	


		
		
		}

		function swap(a,b,c){
			var w=a[b];
			a[b]=a[c];
			a[c]=w;
		
		}
