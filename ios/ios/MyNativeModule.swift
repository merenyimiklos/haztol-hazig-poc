import Foundation
import React


@objc(MyNativeModule)
class MyNativeModule: NSObject {

  @objc(callFragmentMethod:)
  func callFragmentMethod(param: String) {
      SharedState.shared.updateTextFieldValue(param)
  }
}
