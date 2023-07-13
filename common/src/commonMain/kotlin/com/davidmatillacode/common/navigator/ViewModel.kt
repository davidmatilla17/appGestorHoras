
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class ViewModel : InstanceKeeper.Instance, CoroutineScope {
  override val coroutineContext: CoroutineContext = Dispatchers.Unconfined + SupervisorJob()
  override fun onDestroy() { coroutineContext.cancel() }
}
