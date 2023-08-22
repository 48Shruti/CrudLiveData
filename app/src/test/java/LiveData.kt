import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shruti.crudlivedata.NotesEntity

class LiveData : ViewModel() {
    var liveData = MutableLiveData<NotesEntity>()
}