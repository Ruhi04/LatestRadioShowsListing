package radioshowslisting.radioshowslisting.main.errors

import radioshowslisting.radioshowslisting.errors.ErrorHandler
import radioshowslisting.radioshowslisting.errors.ErrorHandlerTemplate
import radioshowslisting.radioshowslisting.errors.alert.HttpExceptionHandler
import radioshowslisting.radioshowslisting.main.ui.MainActivity
import javax.inject.Inject

class MainErrorHandler @Inject constructor(
        private val activity: MainActivity
) : ErrorHandlerTemplate() {
    override val errorHandler: ErrorHandler
        get() {
            return HttpExceptionHandler(activity)
        }
}