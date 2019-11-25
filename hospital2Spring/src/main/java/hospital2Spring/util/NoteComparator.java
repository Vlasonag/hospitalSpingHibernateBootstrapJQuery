package hospital2Spring.util;


import hospital2Spring.model.entity.Note; 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class NoteComparator implements Comparator<NoteDTO>{

	@Override
	public int compare(NoteDTO a, NoteDTO b) {
		long t1 = a.getDate().getTime();
	    long t2 = b.getDate().getTime();
	    if(t2 > t1)
            return 1;
	    else if(t1 > t2)
            return -1;
	    else
            return 0;
		
	}
}