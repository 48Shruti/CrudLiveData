import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shruti.crudlivedata.LiveDataEntity

class LiveData : ViewModel() {
    var liveData = MutableLiveData<LiveDataEntity>()
}