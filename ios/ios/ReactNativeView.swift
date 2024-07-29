import SwiftUI
import UIKit

struct ReactNativeView: UIViewControllerRepresentable {
    @ObservedObject var sharedState: SharedState
    
    func makeUIViewController(context: Context) -> ReactNativeViewController {
           let viewController = ReactNativeViewController()
           viewController.sharedState = sharedState
           return viewController
    }
    
    func updateUIViewController(_ uiViewController: ReactNativeViewController, context: Context) {
           uiViewController.updateReactNativeView(with: sharedState.textFieldValue)
    }
}
