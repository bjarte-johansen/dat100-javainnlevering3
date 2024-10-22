package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}

	private static String style = """
<style>
	.post{padding:16px;border:1px solid #CCC;margin-bottom:16px;display: flow-root;}
	.id{font-weight:bold;}
	.user{}
	.date{font-style:italic;}
	.content{float:right;display:inline-block;width:70%;}
	.text:before{content: '\"';}
	.text:after{content: '\"';}
	.image{float:left;display:inline-block;width:20%;margin-right:10%;margin-top:0px;}
	.image img{max-height: 100px; width: auto; border: 1px solid #CCC; width: 100%;}
</style>
""";
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t" + style + "\t<body>\n" + 
	        "\t\t<h1>DAT100 Blogg</h1>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		var sb = new StringBuilder(1024 * 100);
        for (Innlegg innlegg : getSamling()) {
            if (innlegg != null) {
            	sb.append("<div class=\"post\">\n");
            	sb.append(innlegg.toHTML());
            	sb.append("</div>\n");
            }
        }
        
        return HTMLPREFIX + sb.toString() + HTMLPOSTFIX;
	}
}
