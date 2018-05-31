package radioshowslisting.radioshowslisting.errors

/**
 * Chain for error handling.
 */
interface ErrorHandler {
    fun handleError(error: Throwable)
}

