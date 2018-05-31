package radioshowslisting.radioshowslisting.errors

abstract class ErrorHandlerTemplate : ErrorHandler {

    internal abstract val errorHandler: ErrorHandler

    override fun handleError(error: Throwable) {
        errorHandler.handleError(error)
    }
}

