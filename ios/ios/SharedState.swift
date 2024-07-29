import Combine
import SwiftUI

class SharedState: ObservableObject {
    @Published var textFieldValue: String = ""
       
    static let shared = SharedState()

    private init() {}

    func updateTextFieldValue(_ newValue: String) {
       DispatchQueue.main.async {
           self.textFieldValue = newValue
       }
    }
}
