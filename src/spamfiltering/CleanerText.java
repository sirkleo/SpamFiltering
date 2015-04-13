/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamfiltering;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author jleonp
 */
public class CleanerText {
    
    HashMap<String, Boolean> stopWords;

    public CleanerText() {
        stopWords = new HashMap<>();
         String[] stopWordsEsp = {
            "",
            "un",
            "una",
            "unas",
            "unos",
            "uno",
            "sobre",
            "todo",
            "también",
            "tras",
            "otro",
            "algún",
            "alguno",
            "alguna",
            "algunos",
            "algunas",
            "ser",
            "es",
            "soy",
            "eres",
            "somos",
            "sois",
            "estoy",
            "esta",
            "estamos",
            "estais",
            "estan",
            "como",
            "en",
            "para",
            "atras",
            "porque",
            "por qué",
            "estado",
            "estaba",
            "ante",
            "antes",
            "siendo",
            "ambos",
            "pero",
            "por",
            "poder",
            "puede",
            "puedo",
            "podemos",
            "podeis",
            "pueden",
            "fui",
            "fue",
            "fuimos",
            "fueron",
            "hacer",
            "hago",
            "hace",
            "hacemos",
            "haceis",
            "hacen",
            "cada",
            "fin",
            "incluso",
            "primero",
            "desde",
            "conseguir",
            "consigo",
            "consigue",
            "consigues",
            "conseguimos",
            "consiguen",
            "ir",
            "voy",
            "va",
            "vamos",
            "vais",
            "van",
            "vaya",
            "gueno",
            "ha",
            "tener",
            "tengo",
            "tiene",
            "tenemos",
            "teneis",
            "tienen",
            "el",
            "la",
            "lo",
            "las",
            "los",
            "su",
            "aqui",
            "mio",
            "tuyo",
            "ellos",
            "ellas",
            "nos",
            "nosotros",
            "vosotros",
            "vosotras",
            "si",
            "dentro",
            "solo",
            "solamente",
            "saber",
            "sabes",
            "sabe",
            "sabemos",
            "sabeis",
            "saben",
            "ultimo",
            "largo",
            "bastante",
            "haces",
            "muchos",
            "aquellos",
            "aquellas",
            "sus",
            "entonces",
            "tiempo",
            "verdad",
            "verdadero",
            "verdadera",
            "cierto",
            "ciertos",
            "cierta",
            "ciertas",
            "intentar",
            "intento",
            "intenta",
            "intentas",
            "intentamos",
            "intentais",
            "intentan",
            "dos",
            "bajo",
            "arriba",
            "encima",
            "usar",
            "uso",
            "usas",
            "usa",
            "usamos",
            "usais",
            "usan",
            "emplear",
            "empleo",
            "empleas",
            "emplean",
            "ampleamos",
            "empleais",
            "valor",
            "muy",
            "era",
            "eras",
            "eramos",
            "eran",
            "modo",
            "bien",
            "cual",
            "cuando",
            "donde",
            "mientras",
            "quien",
            "con",
            "entre",
            "sin",
            "trabajo",
            "trabajar",
            "trabajas",
            "trabaja",
            "trabajamos",
            "trabajais",
            "trabajan",
            "podria",
            "podrias",
            "podriamos",
            "podrian",
            "podriais",
            "yo",
            "aquel",
            "que",
            "del",
            "a",
            "se",
            "mexico",
            "y",
            "de",
            "e","u"
        };
        String [] stopWordsEng={
            "a's"	,"able",	"about",	"above"	,"according",
"accordingly",	"across",	"actually"	,"after"	,"afterwards",
"again",	"against"	,"ain't"	,"all"	,"allow",
"allows"	,"almost",	"alone"	,"along",	"already",
"also",	"although",	"always",	"am"	,"among",
"amongst",	"an"	,"and"	,"another"	,"any",
"anybody",	"anyhow",	"anyone",	"anything",	"anyway",
"anyways",	"anywhere",	"apart",	"appear",	"appreciate",
"appropriate",	"are"	,"aren't",	"around"	,"as",
"aside",	"ask",	"asking",	"associated",	"at",
"available",	"away"	,"awfully",	"be",	"became",
"because",	"become"	,"becomes"	,"becoming","been",
"before",	"beforehand"	,"behind"	,"being"	,"believe",
"below",	"beside",	"besides"	,"best"	,"better",
"between",	"beyond"	,"both"	,"brief"	,"but",
"by"	,"c'mon",	"c's"	,"came"	,"can",
"can't",	"cannot",	"cant",	"cause",	"causes",
"certain",	"certainly","changes",	"clearly"	,"co",
"com"	,"come",	"comes"	,"concerning"	,"consequently",
"consider"	,"considering"	,"contain"	,"containing"	,"contains",
"corresponding",	"could"	,"couldn't"	,"course",	"currently",
"definitely",	"described",	"despite",	"did",	"didn't",
"different",	"do",	"does",	"doesn't"	,"doing",
"don't",	"done"	,"down",	"downwards"	,"during",
"each"	,"edu"	,"eg"	,"eight"	,"either",
"else"	,"elsewhere"	,"enough"	,"entirely",	"especially",
"et"	,"etc",	"even"	,"ever"	,"every",
"everybody"	,"everyone",	"everything"	,"everywhere"	,"ex",
"exactly",	"example",	"except",	"far"	,"few",
"fifth"	,"first",	"five"	,"followed",	"following",
"follows",	"for"	,"former",	"formerly"	,"forth",
"four"	,"from",	"further",	"furthermore"	,"get",
"gets"	,"getting"	,"given",	"gives",	"go",
"goes",	"going",	"gone",	"got"	,"gotten",
"greetings",	"had",	"hadn't",	"happens",	"hardly",
"has"	,"hasn't"	,"have"	,"haven't"	,"having",
"he"	,"he's",	"hello",	"help",	"hence",
"her"	,"here",	"here's"	,"hereafter"	,"hereby",
"herein",	"hereupon"	,"hers"	,"herself",	"hi",
"him",	"himself",	"his",	"hither"	,"hopefully",
"how",	"howbeit",	"however",	"i'd"	,"i'll",
"i'm"	,"i've"	,"ie"	,"if"	,"ignored",
"immediate",	"in",	"inasmuch",	"inc"	,"indeed",
"indicate"	,"indicated"	,"indicates",	"inner",	"insofar",
"instead",	"into"	,"inward"	,"is"	,"isn't",
"it"	,"it'd",	"it'll",	"it's",	"its",
"itself",	"just",	"keep",	"keeps"	,"kept",
"know",	"known"	,"knows",	"last"	,"lately",
"later"	,"latter"	,"latterly"	,"least",	"less",
"lest",	"let",	"let's",	"like"	,"liked",
"likely"	,"little",	"look",	"looking"	,"looks",
"ltd",	"mainly"	,"many",	"may",	"maybe",
"me"	,"mean"	,"meanwhile",	"merely",	"might",
"more",	"moreover",	"most"	,"mostly",	"much",
"must",	"my"	,"myself"	,"name",	"namely","of","the"
/*nd	near	nearly	necessary	need
needs	neither	never	nevertheless	new
next	nine	no	nobody	non
none	noone	nor	normally	not
nothing	novel	now	nowhere	obviously
of	off	often	oh	ok
okay	old	on	once	one
ones	only	onto	or	other
others	otherwise	ought	our	ours
ourselves	out	outside	over	overall
own	particular	particularly	per	perhaps
placed	please	plus	possible	presumably
probably	provides	que	quite	qv
rather	rd	re	really	reasonably
regarding	regardless	regards	relatively	respectively
right	said	same	saw	say
saying	says	second	secondly	see
seeing	seem	seemed	seeming	seems
seen	self	selves	sensible	sent
serious	seriously	seven	several	shall
she	should	shouldn't	since	six
so	some	somebody	somehow	someone
something	sometime	sometimes	somewhat	somewhere
soon	sorry	specified	specify	specifying
still	sub	such	sup	sure
t's	take	taken	tell	tends
th	than	thank	thanks	thanx
that	that's	thats	the	their
theirs	them	themselves	then	thence
there	there's	thereafter	thereby	therefore
therein	theres	thereupon	these	they
they'd	they'll	they're	they've	think
third	this	thorough	thoroughly	those
though	three	through	throughout	thru
thus	to	together	too	took
toward	towards	tried	tries	truly
try	trying	twice	two	un
under	unfortunately	unless	unlikely	until
unto	up	upon	us	use
used	useful	uses	using	usually
value	various	very	via	viz
vs	want	wants	was	wasn't
way	we	we'd	we'll	we're
we've	welcome	well	went	were
weren't	what	what's	whatever	when
whence	whenever	where	where's	whereafter
whereas	whereby	wherein	whereupon	wherever
whether	which	while	whither	who
who's	whoever	whole	whom	whose
why	will	willing	wish	with
within	without	won't	wonder	would
wouldn't	yes	yet	you	you'd
you'll	you're	you've	your	yours
yourself	yourselves	zero*/
        };
        for(String word: stopWordsEsp){
            stopWords.put(word, Boolean.TRUE);
        }
        for(String word: stopWordsEng){
            stopWords.put(word, Boolean.TRUE);
        }
       
    }
    
    public  boolean isStopWord(String word) {
        return stopWords.get(word);
    }

    /*public Boolean findStopWord(String word) {
        HashMap<String, Boolean> stopWords = reloadStopWords();
        return stopWords.get(word);
    }*/


    public static void main(String args[]) {
        try {
            CleanerText cleaner = new CleanerText();
            System.out.println(cleaner.stopWords.get("que"));
            FileInputStream fstream = new FileInputStream("/local_home/markov/Downloads/SpamFiltering/mailtex.txt");
            InputStreamReader Fichero = new InputStreamReader(fstream, "ISO-8859-1");//ISO-8859-1
            BufferedReader br = new BufferedReader(Fichero);
            String linea;
            HashMap<String, Integer> hashmap = new HashMap<>();
            //int line=1;
            while ((linea = br.readLine()) != null) {
                String[] wordsInLine = linea.split("\\ ");
                for (String word : wordsInLine) {
                    word = word.toLowerCase().trim();
                    if (cleaner.stopWords.get(word)!=null) {
                        continue;
                    }
                    if (hashmap.get(word) == null) {
                        hashmap.put(word, 1);
                    } else {
                        int conteo = hashmap.get(word);
                        ++conteo;
                        hashmap.put(word, conteo);
                    }
                }
            }
            ListaOrdenada lista = new ListaOrdenada();
            Set<String> words = hashmap.keySet();
            for (String word : words) {
                lista.insertar(word, hashmap.get(word));
            }
            lista.imprimir();
        } catch (IOException ex) {
            System.out.println("Error en lectura y escritura: " + ex.getMessage());
        }
    }
}
